#!/usr/bin/python                                                                                                                                                                                                                                                                        
import argparse
import subprocess
from subprocess import PIPE, Popen
import sys, os
import glob


#os.system("python tester.py")
''''
for x, y, z in os.walk('/Users/Joshua/Documents/Compsci/PythonProj/Students'):
	for program in z:
		print(z)
		'''
pys = glob.glob('/Users/Joshua/Documents/Compsci/PythonProj/Students/**/*.py')
for program in pys:
	print(program)
	os.system("python %s" %program)
	p = subprocess.Popen(['python', program], stdin=PIPE, stdout=PIPE, stderr=PIPE)
	p.stdin.write('5\n\n')
	out = p.communicate(input = '5\n5\n'.encode())
	print(out)


'''
for files in os.walk('/Users/Joshua/Documents/Compsci/PythonProj/Students'):
	for file in files:
		print(file)


	#for program in files.glob.glob('*.py'):  
		#print(program)

'''