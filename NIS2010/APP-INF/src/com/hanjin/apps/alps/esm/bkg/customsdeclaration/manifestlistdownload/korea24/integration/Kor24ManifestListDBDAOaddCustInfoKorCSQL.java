/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24ManifestListDBDAOaddCustInfoKorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOaddCustInfoKorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L List check후 조회된 Cust count(=searchCustomerInfo) 만큼 Insert
	  * </pre>
	  */
	public Kor24ManifestListDBDAOaddCustInfoKorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("username",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bcs_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestListDBDAOaddCustInfoKorCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_KR_CUST" ).append("\n"); 
		query.append("(BKG_NO, CSTMS_DECL_TP_CD, TRNS_SEQ, BKG_CUST_TP_CD," ).append("\n"); 
		query.append("CNT_CD, CUST_SEQ, CUST_NM, CUST_ADDR, PHN_NO, DMST_PORT_CD, CRE_USR_ID, UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(@[bkg_no], DECODE(@[expt_kcd_tp],'R','R','T','T',@[kcd_tp]), @[kt_seq], @[bcs_tp]," ).append("\n"); 
		query.append("TRIM(@[cnt_cd]), @[cust_cd]," ).append("\n"); 
		query.append("DECODE(@[bkg_cgo_tp],'P','SM LINE CORPORATION',TRIM(BKG_SPCLCHAR_CONV_FNC(@[cust_name], 'Y')))," ).append("\n"); 
		query.append("DECODE(@[bkg_cgo_tp],'P', (" ).append("\n"); 
		query.append("                            SELECT DECODE(@[bcs_tp], 'S'" ).append("\n"); 
		query.append("                                                    ,DECODE(INSTR(A1.LOC_NM, B1.CNT_NM), 0, A1.LOC_NM || ', ' || B1.CNT_NM, A1.LOC_NM)" ).append("\n"); 
		query.append("                        							,CASE" ).append("\n"); 
		query.append("                            							WHEN @[in_bound] = 'I' OR @[in_bound] = 'T' THEN A2.LOC_NM" ).append("\n"); 
		query.append("                            							ELSE DECODE(INSTR(A2.LOC_NM, B2.CNT_NM), 0, A2.LOC_NM || ', ' || B2.CNT_NM, A2.LOC_NM )" ).append("\n"); 
		query.append("                         							END" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BB,MDM_LOCATION A1, MDM_COUNTRY B1, MDM_LOCATION A2, MDM_COUNTRY B2" ).append("\n"); 
		query.append("                            WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                            AND BB.POL_CD = A1.LOC_CD(+)" ).append("\n"); 
		query.append("                            AND A1.CNT_CD = B1.CNT_CD(+)" ).append("\n"); 
		query.append("                            AND BB.POD_CD = A2.LOC_CD(+)" ).append("\n"); 
		query.append("                            AND A2.CNT_CD = B2.CNT_CD(+)" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        ,TRIM(BKG_SPCLCHAR_CONV_FNC(@[cust_addr],'Y')))," ).append("\n"); 
		query.append("TRIM(@[cust_tel]), @[kt_port], @[username], @[username])" ).append("\n"); 

	}
}