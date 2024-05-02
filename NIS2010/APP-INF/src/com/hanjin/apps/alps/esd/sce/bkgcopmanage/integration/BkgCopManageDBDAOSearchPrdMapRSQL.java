/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchPrdMapRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.11 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PCTL_NO           ," ).append("\n"); 
		query.append("BKG_NO            ," ).append("\n"); 
		query.append("COP_NO            ," ).append("\n"); 
		query.append("COP_MAPG_SEQ      ," ).append("\n"); 
		query.append("CRNT_FLG          ," ).append("\n"); 
		query.append("CNTR_NO           ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD      ," ).append("\n"); 
		query.append("COP_OP_TP_CD      ," ).append("\n"); 
		query.append("OB_ITCHG_CTNT     ," ).append("\n"); 
		query.append("MTY_PKUP_YD_CD    ," ).append("\n"); 
		query.append("BKG_OP_RMK        ," ).append("\n"); 
		query.append("MTY_RTN_YD_CD     ," ).append("\n"); 
		query.append("IB_ITCHG_CTNT     ," ).append("\n"); 
		query.append("POR_NOD_CD        ," ).append("\n"); 
		query.append("OCN_ITCHG_CTNT    ," ).append("\n"); 
		query.append("POL_NOD_CD        ," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD   ," ).append("\n"); 
		query.append("BKG_DE_TERM_CD    ," ).append("\n"); 
		query.append("OB_TRO_FLG        ," ).append("\n"); 
		query.append("IB_TRO_FLG        ," ).append("\n"); 
		query.append("COP_PATT_ORD_NO   ," ).append("\n"); 
		query.append("COP_SO_KNT		  ," ).append("\n"); 
		query.append("CRE_USR_ID		  ," ).append("\n"); 
		query.append("UPD_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($bkg_no IN ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("('$bkg_no')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$bkg_no')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${cop_mapg_seq} != '')" ).append("\n"); 
		query.append("AND	COP_MAPG_SEQ IN (" ).append("\n"); 
		query.append("#foreach($cop_mapg_seq IN ${cop_mapg_seq})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("('$cop_mapg_seq')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$cop_mapg_seq')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(CRNT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY COP_MAPG_SEQ" ).append("\n"); 

	}
}