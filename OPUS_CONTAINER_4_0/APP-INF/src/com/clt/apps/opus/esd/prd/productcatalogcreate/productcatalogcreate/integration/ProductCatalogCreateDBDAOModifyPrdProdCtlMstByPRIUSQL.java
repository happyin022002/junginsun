/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRIUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRIUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRI
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRIUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("goh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOModifyPrdProdCtlMstByPRIUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST SET" ).append("\n"); 
		query.append("  BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append(", PRC_CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append(", EQ_TP_CD = @[eq_tp_cd]" ).append("\n"); 
		query.append(", SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append(", SOC_FLG = NVL(@[soc_flg],'N')" ).append("\n"); 
		query.append(", DG_SPCL_FLG = DECODE(@[cgo_tp_cd], 'DG', 'Y', 'N')" ).append("\n"); 
		query.append(", RF_SPCL_FLG = DECODE(@[cgo_tp_cd], 'RF', 'Y', 'N')" ).append("\n"); 
		query.append(", SPCL_AWK_CGO_FLG = DECODE(@[cgo_tp_cd], 'AK', 'Y', 'N')" ).append("\n"); 
		query.append(", BB_SPCL_FLG = DECODE(@[cgo_tp_cd], 'BB', 'Y', 'N')" ).append("\n"); 
		query.append("#if (${goh_cd} != '')" ).append("\n"); 
		query.append(", BKG_HNGR_BAR_TP_CD = @[goh_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append(", ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append(", ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_tp} == 'S') " ).append("\n"); 
		query.append(", SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${ctrt_tp} == 'R') " ).append("\n"); 
		query.append(", RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${ctrt_tp} == 'T') " ).append("\n"); 
		query.append(", TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 

	}
}