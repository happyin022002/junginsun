/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvCopyVODSQL.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvCopyVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COPY된 데이터를 삭제한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvCopyVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}
	
	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("DELETE FROM PRI_SC_NOTE_CONV_CPY" ).append("\n"); 
		query.append("WHERE USR_ID = @[cre_usr_id]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvCopyVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}