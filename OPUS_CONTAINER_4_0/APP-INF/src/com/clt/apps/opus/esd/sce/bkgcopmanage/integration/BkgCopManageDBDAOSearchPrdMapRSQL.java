/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchPrdMapRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.05.03 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchPrdMapRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRD_BKG_COP_MAP 의 정보를 복수의 booking 에 대해 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchPrdMapRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchPrdMapRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO           ," ).append("\n"); 
		query.append("       BKG_NO            ," ).append("\n"); 
		query.append("       COP_NO            ," ).append("\n"); 
		query.append("       COP_MAPG_SEQ      ," ).append("\n"); 
		query.append("       CRNT_FLG          ," ).append("\n"); 
		query.append("       CNTR_NO           ," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD      ," ).append("\n"); 
		query.append("       COP_OP_TP_CD      ," ).append("\n"); 
		query.append("       OB_ITCHG_CTNT     ," ).append("\n"); 
		query.append("       MTY_PKUP_YD_CD    ," ).append("\n"); 
		query.append("       BKG_OP_RMK        ," ).append("\n"); 
		query.append("       MTY_RTN_YD_CD     ," ).append("\n"); 
		query.append("       IB_ITCHG_CTNT     ," ).append("\n"); 
		query.append("       POR_NOD_CD        ," ).append("\n"); 
		query.append("       OCN_ITCHG_CTNT    ," ).append("\n"); 
		query.append("       POL_NOD_CD        ," ).append("\n"); 
		query.append("       BKG_RCV_TERM_CD   ," ).append("\n"); 
		query.append("       BKG_DE_TERM_CD    ," ).append("\n"); 
		query.append("       OB_TRO_FLG        ," ).append("\n"); 
		query.append("       IB_TRO_FLG        ," ).append("\n"); 
		query.append("       COP_PATT_ORD_NO   ," ).append("\n"); 
		query.append("       COP_SO_KNT		 ," ).append("\n"); 
		query.append("       CRE_USR_ID		 ," ).append("\n"); 
		query.append("       UPD_USR_ID		  				" ).append("\n"); 
		query.append("  FROM PRD_BKG_COP_MAP" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("	#foreach($bkg_no IN ${bkg_no})" ).append("\n"); 
		query.append("		#set ($ndx = $velocityCount)" ).append("\n"); 
		query.append("		#if($velocityCount == 1 )" ).append("\n"); 
		query.append("       (    BKG_NO = '$bkg_no'" ).append("\n"); 
		query.append("			#if (${cop_mapg_seq} != '')" ).append("\n"); 
		query.append("				#foreach($cop_mapg_seq IN ${cop_mapg_seq})" ).append("\n"); 
		query.append("					#if($velocityCount == $ndx )" ).append("\n"); 
		query.append("        AND COP_MAPG_SEQ IN (" ).append("\n"); 
		query.append("                   NVL('$cop_mapg_seq', (SELECT MAX(COP_MAPG_SEQ) FROM PRD_BKG_COP_MAP WHERE BKG_NO = '$bkg_no' AND NVL(CRNT_FLG, 'N') = 'Y'))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("        AND COP_MAPG_SEQ IN (" ).append("\n"); 
		query.append("                   NVL(NULL, (SELECT MAX(COP_MAPG_SEQ) FROM PRD_BKG_COP_MAP WHERE BKG_NO = '$bkg_no' AND NVL(CRNT_FLG, 'N') = 'Y'))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("       OR" ).append("\n"); 
		query.append("       (    BKG_NO = '$bkg_no'" ).append("\n"); 
		query.append("			#if (${cop_mapg_seq} != '')" ).append("\n"); 
		query.append("			#foreach($cop_mapg_seq IN ${cop_mapg_seq})" ).append("\n"); 
		query.append("			#if($velocityCount == $ndx )" ).append("\n"); 
		query.append("        AND COP_MAPG_SEQ IN (" ).append("\n"); 
		query.append("                   NVL('$cop_mapg_seq', (SELECT MAX(COP_MAPG_SEQ) FROM PRD_BKG_COP_MAP WHERE BKG_NO = '$bkg_no' AND NVL(CRNT_FLG, 'N') = 'Y'))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("        AND COP_MAPG_SEQ IN (" ).append("\n"); 
		query.append("                   NVL(NULL, (SELECT MAX(COP_MAPG_SEQ) FROM PRD_BKG_COP_MAP WHERE BKG_NO = '$bkg_no' AND NVL(CRNT_FLG, 'N') = 'Y'))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" ORDER BY COP_MAPG_SEQ" ).append("\n"); 

	}
}