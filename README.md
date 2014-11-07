<h1>Microsoft Coding Competition</h1>

<p>This was a coding competition at OSU, the problem description is below. At the competition I wasn't quite able to finish due to program inefficiencies. Afterwards I improved the code by adding the if(){} statements in the mutations(String dna) function. They function to check if a given dna fragment has already been added to the data structure containing all possible mutations. This brought the running time down from 7+ minutes to about a minute (on an old computer).</p>

<h3>Project Description</h3>
<p>Question One Cure the virus | 3 point(s)</p></br>

<p>There is an outbreak of VirusX in Redmond. The local authorities have discovered a vaccine that protects against infection by VirusX. However, they can only produce so many vaccines per week. Your job is to figure out the best order in which people should be vaccinated. Everyone will get vaccinated, but the people more likely to be sick should be vaccinated first. You are more likely to get sick if the virus` DNA closely matches somewhere in your DNA.</p></br>

<p>However, there is a catch: the virus can mutate. Over time, the virus can “cut” letters from its DNA. So it is possible that the AAAAG virus mutates into the AAAG, AAAA, …, A viruses. Removing letters is the only possible mutation: the virus cannot change any letter.</p></br>

<p>For example, if your DNA is GGGGGGGAAAAGGGGGG and the virus DNA is AAAAG, you have 1.0 probability of getting infected because all of the letters of the virus are found in the same order in your DNA. If your DNA was TTTTTTTAAAATTTTTT, then the virus only partially matches your DNA. For partial matches, we define the probability to get sick by the numbers of continuous letters of the virus’ DNA that matches your DNA divided by the total number of letters in the un-mutated virus’ DNA. With the example above, AAAA is the longest possible mutation that matches in your DNA, so your probability of getting sick is len(AAAA) / len(AAAAG): 0.8.</p></br>

<p>You are provided with the DNA of every inhabitant of Redmond and the virus’ DNA. For every inhabitant, you need to output the order in which he/she should get vaccinated. Everyone that has the same probability to get sick should get vaccinated in the same batch. For example, the order of vaccination for inhabitants with the following probability to get sick: [0.0, 0.5, 0.5, 0.0, 1.0] is: [3, 2, 2, 3, 1].</p></br>

<p>Tip</p></br>

<p>Here is a tip for how to get from the “Canonical Sample Input” to “Canonical Sample Output” (described below). Given the TAAT virus and its highest infection score possible mutation for persons 0 to 4, here are the longest matching mutations and the attached probability to get sick for every person:</p></br>

<p>Person #0: T, 0.250</p></br>
<p>Person #1: TAA, 0.750</p></br>
<p>Person #2: TT, 0.500</p></br>
<p>Person #3: TAAT, 1.000</p></br>
<p>Person #4: TA, 0.500</p></br>
<p>Therefore, person 3 has a 1.0 probability of getting sick, so he or she gets vaccinated first. Person 1 is the next highest, so he or she gets vaccinated second. We continue to vaccinate in batches of probability of getting sick, with person 0 getting vaccinated last because he or she has the least probability to get sick.</p></br>

<p>Note that what is described above is not the output you should generate, but a tip on how you can get to the desired output inside your code.</p></br>

<p>Input description/format</br>

<p>The first line of the file contains three numbers: the number of citizens in Redmond, the length of the citizen’s DNA and the length of the virus’ DNA.</p></br>

<p>This is followed by one sequence of DNA per line, representing in order the citizens’ DNA. The last DNA sequence of the file is the virus’ DNA.</p></br>

<p>You can assume that the virus’ DNA sequence is always shorter than the citizen’s DNA sequences.</p></br>

<p>Output description/format</p></br>

<p>The below example becomes clear if we give the “DNA match score” as well as the longest sequence of DNA matched.</p></br>

<p>Person #0: G, 0.333</p></br>
<p>Person #1: GCC, 1.000</p></br>
<p>Person #2: CC, 0.667</p></br>
<p>Person #3: GC, 0.667</p></br>
<p>Person #4: GC, 0.667</p></br>

<p>Person 1 has a 1.0 probability of getting sick, so he gets vaccinated first. Persons 2, 3, and 4 are the next highest probable to get sick, so they get vaccinated second. Person 0 has the least chance to get sick; he gets vaccinated last.</p></br>

<p>Example input</p></br>

<p>5 10 3</p></br>
<p>AGGAAAAGAG</p></br>
<p>CGAGGCCAAC</p></br>
<p>GACAAAACCG</p></br>
<p>GCGACGCAGA</p></br>
<p>AACAGCGCAG</p></br>
<p>GCC</p></br>

<p>Example output</p></br>

<p>Person #0: 3.</p></br>
<p>Person #1: 1.</p></br>
<p>Person #2: 2.</p></br>
<p>Person #3: 2.</p></br>
<p>Person #4: 2.</p>
