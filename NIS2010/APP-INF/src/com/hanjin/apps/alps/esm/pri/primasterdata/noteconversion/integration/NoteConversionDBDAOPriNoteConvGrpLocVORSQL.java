/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NoteConversionDBDAOPriNoteConvGrpLocVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NoteConversionDBDAOPriNoteConvGrpLocVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group location  정보를 조회한다.
	  * </pre>
	  */
	public NoteConversionDBDAOPriNoteConvGrpLocVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.integration").append("\n"); 
		query.append("FileName : NoteConversionDBDAOPriNoteConvGrpLocVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
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
		query.append("SELECT PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("      ,NOTE_CONV_GRP_LOC_CD" ).append("\n"); 
		query.append("      ,NOTE_CONV_GRP_LOC_DESC" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("FROM PRI_NOTE_CONV_GRP_LOC" ).append("\n"); 
		query.append("WHERE PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("ORDER BY NOTE_CONV_GRP_LOC_CD" ).append("\n"); 

	}
}