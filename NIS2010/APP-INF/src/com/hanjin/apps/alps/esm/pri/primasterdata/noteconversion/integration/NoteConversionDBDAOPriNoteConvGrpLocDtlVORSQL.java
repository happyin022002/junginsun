/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NoteConversionDBDAOPriNoteConvGrpLocDtlVORSQL.java
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

public class NoteConversionDBDAOPriNoteConvGrpLocDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Location 하위에 있는 Location Detail 정보를 조회한다.
	  * </pre>
	  */
	public NoteConversionDBDAOPriNoteConvGrpLocDtlVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_grp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.integration").append("\n"); 
		query.append("FileName : NoteConversionDBDAOPriNoteConvGrpLocDtlVORSQL").append("\n"); 
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
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION A1" ).append("\n"); 
		query.append("         WHERE A1.LOC_CD = B1.LOC_CD) LOC_DES" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM PRI_NOTE_CONV_GRP_LOC_DTL B1" ).append("\n"); 
		query.append("WHERE PRC_CTRT_TP_CD =  @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("  AND NOTE_CONV_GRP_LOC_CD = @[note_conv_grp_loc_cd]" ).append("\n"); 

	}
}