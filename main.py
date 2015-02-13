__author__ = 'christian'

import datetime
import logging
import os
import urllib

from google.appengine.api import users
from google.appengine.ext import ndb

import jinja2
import webapp2


isDevelopment = os.environ["SERVER_SOFTWARE"].startswith("Development")

JINJA = jinja2.Environment(
    loader=jinja2.FileSystemLoader(os.path.dirname(__file__)),
    extensions=['jinja2.ext.autoescape'],
    autoescape=True)


class SimplePageHandler(webapp2.RequestHandler):
    def get(self):
        JINJA.globals["year"] = datetime.datetime.now().year
        template = JINJA.get_template('html/%s.html' % self.request.path[1:])
        self.response.write(template.render())


class RootPageHandler(webapp2.RequestHandler):
    def get(self):
        JINJA.globals["year"] = datetime.datetime.now().year
        template = JINJA.get_template('html/about.html')
        self.response.write(template.render())


class ErrorHandler(webapp2.RequestHandler):
    def get(self):
        JINJA.globals["year"] = datetime.datetime.now().year
        template = JINJA.get_template('html/error.html')
        self.response.write(template.render())
        self.response.set_status(404)

app = webapp2.WSGIApplication([
	('/', RootPageHandler), 
	('/about', SimplePageHandler), 
    ('/resume', SimplePageHandler), 
    ('/contact', SimplePageHandler), 
	('/.*', ErrorHandler), 
], debug=isDevelopment)
