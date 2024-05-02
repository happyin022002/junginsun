/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyEurTroBySeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcopyEurTroBySeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eur tro를 copy한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyEurTroBySeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcopyEurTroBySeqCSQL").append("\n"); 
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
		query.append("insert into bkg_eur_tro(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",RQST_SUB_SEQ" ).append("\n"); 
		query.append(",DCGO_SEQ" ).append("\n"); 
		query.append(",RC_SEQ" ).append("\n"); 
		query.append(",AWK_CGO_SEQ" ).append("\n"); 
		query.append(",HLG_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(",CNTR_PKUP_DT" ).append("\n"); 
		query.append(",CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",CNTR_RTN_DT" ).append("\n"); 
		query.append(",EUR_TRNS_TP_CD" ).append("\n"); 
		query.append(",DRP_OFF_PKUP_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_DESC" ).append("\n"); 
		query.append(",BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",TRO_PROC_CD" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CSTMS_CLR_NO" ).append("\n"); 
		query.append(",ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VAT_FLG" ).append("\n"); 
		query.append(",T1_DOC_FLG" ).append("\n"); 
		query.append(",TRNS_REV_AMT" ).append("\n"); 
		query.append(",NMF_TRNS_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_CHG_CD" ).append("\n"); 
		query.append(",SO_CTY_CD" ).append("\n"); 
		query.append(",SO_SEQ_NO" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CORR_NO" ).append("\n"); 
		query.append(",CORR_FLG" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",CFM_OFC_CD" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",CFM_UPD_DT" ).append("\n"); 
		query.append(",CFM_HLG_TP_CD" ).append("\n"); 
		query.append(",CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CFM_CURR_CD" ).append("\n"); 
		query.append(",CFM_REV_AMT" ).append("\n"); 
		query.append(",CFM_VAT_FLG" ).append("\n"); 
		query.append(",CNTR_CFM_FLG" ).append("\n"); 
		query.append(",CNTR_CFM_USR_ID" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tro_seq}!='')" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append(",nvl((select max(tro_seq)" ).append("\n"); 
		query.append("from bkg_eur_tro" ).append("\n"); 
		query.append("where bkg_no 		= @[targetBkg]" ).append("\n"); 
		query.append("and io_bnd_cd 		= 'O'" ).append("\n"); 
		query.append("and cxl_flg 		= 'N'), 0) + 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--tro copy" ).append("\n"); 
		query.append(",rownum" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",RQST_SUB_SEQ" ).append("\n"); 
		query.append(",null DCGO_SEQ" ).append("\n"); 
		query.append(",null RC_SEQ" ).append("\n"); 
		query.append(",null AWK_CGO_SEQ" ).append("\n"); 
		query.append(",HLG_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(",CNTR_PKUP_DT" ).append("\n"); 
		query.append(",CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",CNTR_RTN_DT" ).append("\n"); 
		query.append(",EUR_TRNS_TP_CD" ).append("\n"); 
		query.append(",DRP_OFF_PKUP_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_DESC" ).append("\n"); 
		query.append(",BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",NULL TRO_PROC_CD" ).append("\n"); 
		query.append(",'N'       CXL_FLG" ).append("\n"); 
		query.append(",CSTMS_CLR_NO" ).append("\n"); 
		query.append(",ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VAT_FLG" ).append("\n"); 
		query.append(",T1_DOC_FLG" ).append("\n"); 
		query.append(",TRNS_REV_AMT" ).append("\n"); 
		query.append(",NMF_TRNS_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_CHG_CD" ).append("\n"); 
		query.append(",null      SO_CTY_CD" ).append("\n"); 
		query.append(",null      SO_SEQ_NO" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",NULL 	   CORR_NO" ).append("\n"); 
		query.append(",'N'       CORR_FLG" ).append("\n"); 
		query.append(",'N'       CFM_FLG" ).append("\n"); 
		query.append(",NULL      CFM_USR_ID" ).append("\n"); 
		query.append(",NULL      CFM_OFC_CD" ).append("\n"); 
		query.append(",NULL      CFM_DT" ).append("\n"); 
		query.append(",NULL      CFM_UPD_DT" ).append("\n"); 
		query.append(",NULL      CFM_HLG_TP_CD" ).append("\n"); 
		query.append(",'N'       CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(",NULL      CFM_CURR_CD" ).append("\n"); 
		query.append(",0         CFM_REV_AMT" ).append("\n"); 
		query.append(",'N'       CFM_VAT_FLG" ).append("\n"); 
		query.append(",'N'       CNTR_CFM_FLG" ).append("\n"); 
		query.append(",NULL      CNTR_CFM_USR_ID" ).append("\n"); 
		query.append(",tro_seq      PCTL_NO  --cancel을 제외하고 seq를 1부터 딴 다음 bkg_eur_tro_dtl에 seq를 유지하기 위해 임시로 넣음" ).append("\n"); 
		query.append(",(SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[usr_id])      CRE_OFC_CD" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from  bkg_eur_tro" ).append("\n"); 
		query.append("where bkg_no 		= @[bkg_no]" ).append("\n"); 
		query.append("and io_bnd_cd 	= @[io_bnd_cd]" ).append("\n"); 
		query.append("and cxl_flg		= 'N'" ).append("\n"); 
		query.append("#if(${tro_seq}!='')" ).append("\n"); 
		query.append("--tro split" ).append("\n"); 
		query.append("and tro_seq      = @[tro_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("order by bkg_no, tro_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}