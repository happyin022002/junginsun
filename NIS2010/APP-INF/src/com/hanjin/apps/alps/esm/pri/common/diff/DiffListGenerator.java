/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DiffList.java
*@FileTitle : DiffList
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.11.01 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.common.diff;
 

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import difflib.DiffRow;
import difflib.DiffRowGenerator;
import difflib.DiffRow.Tag;
import difflib.DiffRowGenerator.Builder;
/**
 * NIS2010-Diff  - 두 글의 다른점을 비교한다.
 *
 * @author Minseok Song
 * @see 
 * @since J2EE 1.6
 */
public class DiffListGenerator {
    // Helper method for get the file content 
	protected transient Logger log;
	
	/**
	 * DiffListGenerator 객체 생성<br>
	 */	
	public DiffListGenerator() {
		log = Logger.getLogger(getClass().getName());
		if (log == null)
			log = Logger.getLogger(getClass().getName());
	}
	
    /**
     * New Line Charactor를 기준으로 하여 문장 단위로 List 형태로 
     * 만들어 준다.
     * 
     * @param String 문단의 글
     * @return List<String> New line charactor 단위로 잘린 List
     */
	private List<String> stringToLines(String content) { 
		List<String> lines = new LinkedList<String>();      
		try {               
			String array[]  = content.split("\n");
			for( String line : array){
				lines.add(line);                         
			}         
		} catch (Exception e) {                  
			log.error("err " + e.toString(), e);  
		}               
		return lines;    
	}  
	
    /**
     * 두 글을 비교해준다.
     * 
     * @param String oldContent 기존 글
     * @param String newContent 새로운 글
     * @return DiffList 두 글의 비교 결과
     */
	public DiffList generate(String oldContent, String newContent) {
		return generate( stringToLines(oldContent),stringToLines(newContent));
	}
	
    /**
     * 두 글을 비교해주는데 같은 change된 문장이나 change 되지 않은 문장의 경우는 하나의 tag로 감싸준다.
     * 
     * @param String oldContent 기존 글
     * @param String newContent 새로운 글
     * @return DiffList 두 글의 비교 결과
     */
	public DiffList generateMergeList(String oldContent, String newContent) {
		return generateMergeList( stringToLines(oldContent),stringToLines(newContent));
	}
	
    /**
     * 두 글을 비교해주는데 같은 change된 문장이나 change 되지 않은 문장의 경우는 하나의 tag로 감싸준다.
     * 
     * @param List<String> original 기존 글
     * @param List<String>  revised 새로운 글
     * @return DiffList 두 글의 비교 결과
     */
	public DiffList generateMergeList(List<String> original, List<String>  revised) {
		DiffList diffList = generate(original,  revised);
		
//		for(int i = 0 ; i < diffList.size();i++){
//			System.out.println("generateMergeList TAG :"+diffList.getTag(i));
//			System.out.println("generateMergeList OLD :"+diffList.getOldLine(i));
//			System.out.println("generateMergeList NEW :"+diffList.getNewLine(i));
//		}
		
		
		DiffList data = new DiffList();
//		boolean isOpen = false;
		StringBuffer buffOld = new StringBuffer();
		StringBuffer buffNew = new StringBuffer();
		int preOpenTag =0;
		if( diffList != null ){
			for(int i = 0 ; i < diffList.size() ; i++){
				if( diffList.getTag(i) == DiffList.OPEN_CHANGE_TAG || diffList.getTag(i) == DiffList.OPEN_TAG){
//					isOpen = true;
					buffOld.append(diffList.getOldLine(i).replaceAll("  ", " &nbsp;"));
					buffNew.append(diffList.getNewLine(i).replaceAll("  ", " &nbsp;"));
					preOpenTag = diffList.getTag(i) ;
				}else if(diffList.getTag(i) == DiffList.CLOSE_CHANGE_TAG || diffList.getTag(i) == DiffList.CLOSE_TAG ){
//					isOpen = false;
					data.addLine(buffOld.toString(), buffNew.toString(), preOpenTag);
					data.addLine(null,null, diffList.getTag(i));
					buffOld.setLength(0);
					buffNew.setLength(0);
				}else{
					// 처음부터 바뀐것이 없을때는 Data tag가 오는데 이때는 open tag가 없음. 그래서 필요
//					if( isOpen == false ){
//						isOpen = true;
//						preOpenTag = DiffList.OPEN_TAG ;
//					}
					buffOld.append("<BR>"+diffList.getOldLine(i).replaceAll("  ", " &nbsp;"));
					buffNew.append("<BR>"+diffList.getNewLine(i).replaceAll("  ", " &nbsp;"));
					
				}
			}
		}
		return data;
	}


	
    /**
     * 두 글을 비교해 DiffRowGenerator가 만든 결과를 그대로 DiffList Object에 담아 준다.
     * 
     * @param List<String> original 기존 글
     * @param List<String>  revised 새로운 글
     * @return DiffList 두 글의 비교 결과
     */
	public DiffList generate(List<String> original, List<String>  revised) {  
		DiffList diffList = new DiffList();
		Builder builder = new DiffRowGenerator.Builder();
		builder.ignoreBlankLines(true);
		builder.ignoreWhiteSpaces(true);
		builder.showInlineDiffs(true);
		builder.columnWidth(Integer.MAX_VALUE);
		 
		DiffRowGenerator generator =  builder.build();
		
		List<DiffRow> rows = generator.generateDiffRows(original, revised);      
		//Patch patch = DiffUtils.diff(original, revised);         
		boolean isChange = false;
		int tagType = 0;
		boolean isOpenTag = false;
		int i = 0;
		for (DiffRow row: rows ) {
			i++;
			String oldLine = row.getOldLine();
			String newLine = row.getNewLine();
			Tag tag = row.getTag();			 
			
		 
//			System.out.println("generateMergeList1- TAG :"+tag);
//			System.out.println("generateMergeList1- OLD :"+oldLine);
//			System.out.println("generateMergeList1- NEW :"+newLine);
	 
			
			if(tag.equals(Tag.EQUAL)){
				tagType = DiffList.DATA;
				if( isChange == true){
					//System.out.println("Close Tag >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tag);
					diffList.addLine(null, null,  DiffList.CLOSE_CHANGE_TAG);
					isChange = false;
					if( i < rows.size() ){
						tagType = DiffList.OPEN_TAG;
						isOpenTag = true;
					}else{
						isOpenTag = false;
					}
				}else{
					if( i < rows.size() && isOpenTag == false){
						tagType = DiffList.OPEN_TAG;
						isOpenTag = true;
					}
				}
			}else{
				tagType = DiffList.CHANGE_DATA;
				if( isChange == false){
					if( isOpenTag == true){ 
						diffList.addLine(null, null,  DiffList.CLOSE_TAG);
					}
					isOpenTag = true;
					//System.out.println("Open Tag <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+tag);
					isChange = true;
					tagType = DiffList.OPEN_CHANGE_TAG;
				} 
			} 
			
			//System.out.println("Old "+oldLine);   
			//System.out.println("New "+newLine);   
			diffList.addLine(oldLine, newLine, tagType);
		}  
		if(isOpenTag == true){
			if( tagType == DiffList.OPEN_TAG){
				diffList.addLine(null, null,  DiffList.CLOSE_TAG);
			}else{
				diffList.addLine(null, null,  DiffList.CLOSE_CHANGE_TAG);
			}
		}

		return diffList;
	} 

}
