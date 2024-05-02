/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOModifyCustAddrRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOModifyCustAddrRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Address Request 정보를 수정한다.
	  * </pre>
	  */
	public PartnerDBDAOModifyCustAddrRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOModifyCustAddrRqstUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUST_ADDR_RQST " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append(",	CUST_SEQ	= TO_NUMBER(NVL(@[cust_seq], 0))" ).append("\n"); 
		query.append(",	BZET_ADDR	= NVL(@[bzet_addr], BZET_ADDR)" ).append("\n"); 
		query.append(",   BZET_NM		= NVL(@[cust_lgl_eng_nm], BZET_NM)" ).append("\n"); 
		query.append(",   CNT_CD		= @[cust_cnt_cd]" ).append("\n"); 
		query.append(",	UPD_DT		= NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",   ADDR_TP_CD  =@[addr_tp_cd]      " ).append("\n"); 
		query.append("--,PRMRY_CHK_FLG   = [prmry_chk_flg]   " ).append("\n"); 
		query.append(",CTY_NM          =NVL(@[cty_nm], CTY_NM)" ).append("\n"); 
		query.append(",STE_CD          =NVL(@[ste_cd], STE_CD)" ).append("\n"); 
		query.append(",ZIP_CD          =NVL(@[zip_cd], ZIP_CD)          " ).append("\n"); 
		query.append(",CNTC_EML        =NVL(@[cntc_eml], CNTC_EML)" ).append("\n"); 
		query.append(",CNTC_PSON_NM    =NVL(@[cntc_pson_nm], CNTC_PSON_NM)    " ).append("\n"); 
		query.append(",BZET_RMK        =NVL(@[bzet_rmk], BZET_RMK)" ).append("\n"); 
		query.append(",LOCL_ADDR1      =NVL(@[locl_addr1], LOCL_ADDR1)      " ).append("\n"); 
		query.append(",LOCL_ADDR2      =NVL(@[locl_addr2], LOCL_ADDR2)      " ).append("\n"); 
		query.append(",LOCL_ADDR3      =NVL(@[locl_addr3], LOCL_ADDR3)      " ).append("\n"); 
		query.append(",LOCL_ADDR4      =NVL(@[locl_addr4], LOCL_ADDR4)    " ).append("\n"); 
		query.append("WHERE  RQST_NO		  = @[rqst_no]" ).append("\n"); 
		query.append("--AND ADDR_TP_CD        = '1'" ).append("\n"); 
		query.append("AND ADDR_SEQ          = NVL(@[addr_seq], 0)" ).append("\n"); 
		query.append("--AND PRMRY_CHK_FLG     = 'Y'" ).append("\n"); 

	}
}