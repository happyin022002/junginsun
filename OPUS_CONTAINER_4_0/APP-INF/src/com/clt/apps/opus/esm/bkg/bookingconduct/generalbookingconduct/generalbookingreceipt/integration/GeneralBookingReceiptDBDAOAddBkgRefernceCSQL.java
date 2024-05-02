/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgRefernceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.01 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddBkgRefernceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * reference no 정보를 추가한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgRefernceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ref_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgRefernceCSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("BKG_REF_HIS A" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BKG_REFERENCE A" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append(", @[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append("#if (${bkg_ref_tp_cd}== 'CTPO')" ).append("\n"); 
		query.append(", 'CTPO' AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", @[bkg_ref_tp_cd] AS BKG_REF_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_ref_tp_cd}== 'CTPO')" ).append("\n"); 
		query.append("AND A.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.BKG_REF_TP_CD = E.BKG_REF_TP_CD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("CUST_REF_NO_CTNT   = @[cust_ref_no_ctnt]," ).append("\n"); 
		query.append("UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT        = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("CORR_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("REF_SEQ," ).append("\n"); 
		query.append("BKG_REF_TP_CD, CUST_REF_NO_CTNT, CNTR_NO," ).append("\n"); 
		query.append("CNTR_MF_SEQ, CPY_DESC_FLG, CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("'TMP0000001'," ).append("\n"); 
		query.append("NVL((SELECT  NVL(MAX(REF_SEQ),0)+1 AS SEQ FROM BKG_REF_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("), 1)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("NVL((SELECT  NVL(MAX(REF_SEQ),0)+1 AS SEQ FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("), 1)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("@[bkg_ref_tp_cd], @[cust_ref_no_ctnt], @[cntr_no]," ).append("\n"); 
		query.append("@[cntr_mf_seq], @[cpy_desc_flg], @[cre_usr_id]," ).append("\n"); 
		query.append("sysdate, @[upd_usr_id], sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}