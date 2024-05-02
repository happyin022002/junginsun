/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgVVDNotBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.07.17 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgVVDNotBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EN/TN/TS에서 부킹VVD관련 정보를 얻어온다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBkgVVDNotBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgVVDNotBkgRSQL").append("\n"); 
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
		query.append("SELECT CO.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("DECODE (CO.CNTR_HNGR_RCK_CD, NULL, 'N', 'Y') CNTR_HNGR_RCK_CD, CO.ACIAC_DIV_CD," ).append("\n"); 
		query.append("CO.RFUB_FLG, CO.DISP_FLG, CO.IMDT_EXT_FLG, CO.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CO.AGMT_CTY_CD, CO.AGMT_SEQ, CO.DMG_FLG, '0' CNMV_LVL_NO, @[bkg_cgo_tp_cd] FCNTR_FLG" ).append("\n"); 
		query.append("FROM MST_CONTAINER CO" ).append("\n"); 
		query.append("WHERE CO.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}