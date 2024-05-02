/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOCopyPlnSoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.30 김인수
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

public class BkgCopManageDBDAOCopyPlnSoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * org_cop_no 로 sce_pln_So_list 를 조회하여 신규 cop_no 로 생성한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOCopyPlnSoListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCopyPlnSoListCSQL").append("\n"); 
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
		query.append("insert into SCE_PLN_SO_LIST (" ).append("\n"); 
		query.append("CTRL_OFC_CD                 ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD              ," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD            ," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT             ," ).append("\n"); 
		query.append("COP_NO                      ," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ            ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD             ," ).append("\n"); 
		query.append("N1ST_NOD_CD                 ," ).append("\n"); 
		query.append("N2ND_NOD_CD                 ," ).append("\n"); 
		query.append("N3RD_NOD_CD                 ," ).append("\n"); 
		query.append("N4TH_NOD_CD                 ," ).append("\n"); 
		query.append("PCTL_IO_BND_CD              ," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ               ," ).append("\n"); 
		query.append("TRNS_RQST_OFC_CD            ," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID            ," ).append("\n"); 
		query.append("TRNS_RQST_RSN               ," ).append("\n"); 
		query.append("TRSP_MOD_CD                 ," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD  ," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG        ," ).append("\n"); 
		query.append("CRE_USR_ID                  ," ).append("\n"); 
		query.append("CRE_DT                      ," ).append("\n"); 
		query.append("UPD_USR_ID                  ," ).append("\n"); 
		query.append("UPD_DT                      ," ).append("\n"); 
		query.append("DELT_USR_ID                 ," ).append("\n"); 
		query.append("DELT_DT                     ," ).append("\n"); 
		query.append("DOR_ARR_DT                  ," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CTRL_OFC_CD                 ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD              ," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD            ," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT             ," ).append("\n"); 
		query.append("@[cop_no]                   ," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ            ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD             ," ).append("\n"); 
		query.append("N1ST_NOD_CD                 ," ).append("\n"); 
		query.append("N2ND_NOD_CD                 ," ).append("\n"); 
		query.append("N3RD_NOD_CD                 ," ).append("\n"); 
		query.append("N4TH_NOD_CD                 ," ).append("\n"); 
		query.append("PCTL_IO_BND_CD              ," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ               ," ).append("\n"); 
		query.append("TRNS_RQST_OFC_CD            ," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID            ," ).append("\n"); 
		query.append("TRNS_RQST_RSN               ," ).append("\n"); 
		query.append("TRSP_MOD_CD                 ," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD  ," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG        ," ).append("\n"); 
		query.append("CRE_USR_ID                  ," ).append("\n"); 
		query.append("CRE_DT                      ," ).append("\n"); 
		query.append("UPD_USR_ID                  ," ).append("\n"); 
		query.append("UPD_DT                      ," ).append("\n"); 
		query.append("DELT_USR_ID                 ," ).append("\n"); 
		query.append("DELT_DT                     ," ).append("\n"); 
		query.append("DOR_ARR_DT                  ," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("WHERE COP_NO = @[org_cop_no])" ).append("\n"); 

	}
}