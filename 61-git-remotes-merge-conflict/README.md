# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
   git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
      Cloning into 'OOP-git-merge-conflict-test'...
      remote: Enumerating objects: 12, done.
      remote: Counting objects: 100% (4/4), done.
      remote: Compressing objects: 100% (3/3), done.
      remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
      Receiving objects: 100% (12/12), done.
      Resolving deltas: 100% (2/2), done.

2. Ci si assicuri di avere localmente entrambi i branch remoti
   cd OOP-git-merge-conflict-test/

   git branch -a
      * master
      remotes/origin/HEAD -> origin/master
      remotes/origin/feature
      remotes/origin/master

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
   git merge origin/feature
   Auto-merging HelloWorld.java
   CONFLICT (content): Merge conflict in HelloWorld.java
   Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
   /////////////////////////////////////////////////

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
   /////////////////////////////////////////////////

6. Si crei un nuovo repository nel proprio github personale
   /////////////////////////////////////////////////

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
   nano HelloWorld.java
      public final class HelloWorld {

         private static final String AUTHOR = "Danilo Pianini";

         public static void main(final String[] args) {
            System.out.println("This program has been realised by " + AUTHOR);
            System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
            
         }

         public static int procNumber() {
            return Runtime.getRuntime().availableProcessors();
         }
      }
   git add HelloWorld.java
   git status
      On branch master
      Your branch is up to date with '61-git-remote-merge-conflict/master'.

      All conflicts fixed but you are still merging.
      (use "git commit" to conclude merge)

      Changes to be committed:
            modified:   HelloWorld.java
   git commit -m "Aggiunto HelloWorld.java modificato"
   git status
      On branch master
      Your branch is ahead of '61-git-remote-merge-conflict/master' by 2 commits.
      (use "git push" to publish your local commits)

      nothing to commit, working tree clean

8. Si faccia push del branch `master` sul proprio repository
   git push 61-git-remote-merge-conflict
   Enumerating objects: 10, done.
   Counting objects: 100% (10/10), done.
   Delta compression using up to 24 threads
   Compressing objects: 100% (6/6), done.
   Writing objects: 100% (6/6), 739 bytes | 739.00 KiB/s, done.
   Total 6 (delta 2), reused 1 (delta 0), pack-reused 0 (from 0)
   remote: Resolving deltas: 100% (2/2), completed with 1 local object.
   To https://github.com/PaoloFoschini/61-git-remote-merge-conflicts.git
      8e0f29c..0d902e8  master -> master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
   git branch --set-upstream-to=61-git-remote-merge-conflict/master master
   branch 'master' set up to track '61-git-remote-merge-conflict/master'.

