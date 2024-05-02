/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendDBDAOSearchGetTagretVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.29 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOSearchGetTagretVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 324 발송 대상이 되는 VVD별로 조회를 해온다.
	  * </pre>
	  */
	public Edi324SendDBDAOSearchGetTagretVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi324send.integration").append("\n"); 
		query.append("FileName : Edi324SendDBDAOSearchGetTagretVVDRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("EDI_SND_SEQ," ).append("\n"); 
		query.append("MNL_FLG," ).append("\n"); 
		query.append("EDI_SND_TP_CD," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("LLOYD_VSL_NO," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("POL_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(POL_DEP_ACT_DT,'YYYYMMDDHH24MISS') POL_DEP_ACT_DT," ).append("\n"); 
		query.append("POD_YD_CD," ).append("\n"); 
		query.append("POD_NM," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("TO_CHAR(POD_ESTM_ARR_DT,'YYYYMMDDHH24MISS') POD_ESTM_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(POD_ESTM_ARR_GDT,'YYYYMMDDHH24MISS') POD_ESTM_ARR_GDT," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("CNTR_WGT," ).append("\n"); 
		query.append("CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("CNTR_LBS_WGT," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_LEN," ).append("\n"); 
		query.append("CNTR_HGT," ).append("\n"); 
		query.append("CNTR_SEAL_NO," ).append("\n"); 
		query.append("ORG_YD_LOC_CTY_NM," ).append("\n"); 
		query.append("ORG_YD_LOC_STE_CD," ).append("\n"); 
		query.append("ORG_LOC_NM," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("DEST_YD_LOC_CTY_NM," ).append("\n"); 
		query.append("DEST_YD_LOC_STE_CD," ).append("\n"); 
		query.append("DEST_LOC_NM," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("DG_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID" ).append("\n"); 
		query.append("FROM SCE_EDI_324_SND_RSLT SLT" ).append("\n"); 
		query.append("WHERE EDI_SND_TP_CD ='S'" ).append("\n"); 
		query.append("AND   EDI_SND_RMK ='Saved'" ).append("\n"); 
		query.append("ORDER BY VSL_CD ,SKD_VOY_NO, SKD_DIR_CD ASC" ).append("\n"); 

	}
}