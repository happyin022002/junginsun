/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerDBDAOAddCustAddrCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.23 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOAddCustAddrCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Address 정보를 생성한다.
	  * </pre>
	  */
	public PartnerDBDAOAddCustAddrCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prmry_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddCustAddrCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_ADDR(" ).append("\n"); 
		query.append("   CUST_CNT_CD" ).append("\n"); 
		query.append(",  CUST_SEQ " ).append("\n"); 
		query.append(",  ADDR_TP_CD" ).append("\n"); 
		query.append(",  ADDR_SEQ" ).append("\n"); 
		query.append(",  BZET_NM" ).append("\n"); 
		query.append(",  BZET_ADDR" ).append("\n"); 
		query.append(",  CNT_CD" ).append("\n"); 
		query.append(",  CTY_NM" ).append("\n"); 
		query.append(",  STE_CD" ).append("\n"); 
		query.append(",  ZIP_CD" ).append("\n"); 
		query.append(",  CNTC_EML" ).append("\n"); 
		query.append(",  CNTC_PSON_NM" ).append("\n"); 
		query.append(",  LOCL_ADDR1" ).append("\n"); 
		query.append(",  LOCL_ADDR2" ).append("\n"); 
		query.append(",  LOCL_ADDR3" ).append("\n"); 
		query.append(",  LOCL_ADDR4" ).append("\n"); 
		query.append(",  BZET_RMK" ).append("\n"); 
		query.append(",  PRMRY_CHK_FLG" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",	@[addr_tp_cd]" ).append("\n"); 
		query.append(",	@[addr_seq]" ).append("\n"); 
		query.append(",	@[bzet_nm]" ).append("\n"); 
		query.append(",	@[bzet_addr]" ).append("\n"); 
		query.append(",	@[cnt_cd]" ).append("\n"); 
		query.append(",	@[cty_nm]" ).append("\n"); 
		query.append(",	@[ste_cd]" ).append("\n"); 
		query.append(",	@[zip_cd]" ).append("\n"); 
		query.append(",	@[cntc_eml]" ).append("\n"); 
		query.append(",	@[cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[locl_addr1]" ).append("\n"); 
		query.append(",	@[locl_addr2]" ).append("\n"); 
		query.append(",	@[locl_addr3]" ).append("\n"); 
		query.append(",	@[locl_addr4]" ).append("\n"); 
		query.append(",	@[bzet_rmk]" ).append("\n"); 
		query.append(",	@[prmry_chk_flg]" ).append("\n"); 
		query.append(",	@[delt_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}