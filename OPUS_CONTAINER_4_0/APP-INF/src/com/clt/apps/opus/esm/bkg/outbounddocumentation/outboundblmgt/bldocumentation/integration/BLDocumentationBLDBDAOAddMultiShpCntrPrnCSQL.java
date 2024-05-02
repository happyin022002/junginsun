/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOAddMultiShpCntrPrnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOAddMultiShpCntrPrnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Shipment를 입력한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOAddMultiShpCntrPrnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ncm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOAddMultiShpCntrPrnCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_SHP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    CNTR_MF_SEQ," ).append("\n"); 
		query.append("    CNTR_SEQ," ).append("\n"); 
		query.append("    CNTR_NO," ).append("\n"); 
		query.append("    PCK_QTY," ).append("\n"); 
		query.append("    PCK_TP_CD," ).append("\n"); 
		query.append("    CNTR_MF_WGT," ).append("\n"); 
		query.append("    WGT_UT_CD," ).append("\n"); 
		query.append("    MEAS_QTY," ).append("\n"); 
		query.append("    MEAS_UT_CD," ).append("\n"); 
		query.append("    MK_DESC," ).append("\n"); 
		query.append("    CMDT_DESC," ).append("\n"); 
		query.append("    PRN_FLG," ).append("\n"); 
		query.append("    CNTR_SEAL_NO1," ).append("\n"); 
		query.append("    CNTR_SEAL_NO2," ).append("\n"); 
		query.append("    HAMO_TRF_CD," ).append("\n"); 
		query.append("    CMDT_HS_CD," ).append("\n"); 
		query.append("    NCM_NO," ).append("\n"); 
		query.append("    PO_NO," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[bkg_no]," ).append("\n"); 
		query.append("	(SELECT NVL(MAX(CNTR_MF_SEQ),0)+1 FROM BKG_CNTR_SHP WHERE BKG_NO=@[bkg_no] AND CNTR_SEQ=@[cntr_seq])," ).append("\n"); 
		query.append("    @[cntr_seq]," ).append("\n"); 
		query.append("    @[cntr_no]," ).append("\n"); 
		query.append("    @[pck_qty]," ).append("\n"); 
		query.append("    @[pck_tp_cd]," ).append("\n"); 
		query.append("    @[cntr_mf_wgt]," ).append("\n"); 
		query.append("    @[wgt_ut_cd]," ).append("\n"); 
		query.append("    @[meas_qty]," ).append("\n"); 
		query.append("    @[meas_ut_cd]," ).append("\n"); 
		query.append("    @[mk_desc]," ).append("\n"); 
		query.append("    @[cmdt_desc]," ).append("\n"); 
		query.append("    DECODE(@[prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    @[cntr_seal_no1]," ).append("\n"); 
		query.append("    @[cntr_seal_no2]," ).append("\n"); 
		query.append("    @[hamo_trf_cd]," ).append("\n"); 
		query.append("    @[cmdt_hs_cd]," ).append("\n"); 
		query.append("    @[ncm_no]," ).append("\n"); 
		query.append("    @[po_no]," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}