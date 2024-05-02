/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOAddBkgBlckListMntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAddBkgBlckListMntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에서 warning 메시지가 떴을 때, 확인을 누르고 진행했던 BKG의 데이터들을 인터페이스한다.
	  * BKG_BLCK_KW_LIST 테이블의 keyword 참고
	  * </pre>
	  */
	public BookingUtilDBDAOAddBkgBlckListMntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_xter_rmk_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_desc_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_desc_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blck_kw_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blck_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAddBkgBlckListMntrCSQL").append("\n"); 
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
		query.append("INSERT " ).append("\n"); 
		query.append("  INTO BKG_BLCK_LIST_MNTR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         BLCK_KW_TP_CD" ).append("\n"); 
		query.append("        ,BLCK_KW_TP_SEQ" ).append("\n"); 
		query.append("        ,BKG_NO" ).append("\n"); 
		query.append("        ,BLCK_KW_NM" ).append("\n"); 
		query.append("        ,BL_NO" ).append("\n"); 
		query.append("        ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,CTRT_OFC_CD" ).append("\n"); 
		query.append("        ,OP_CNTR_QTY" ).append("\n"); 
		query.append("        ,SHPR_CNT_CD" ).append("\n"); 
		query.append("        ,SHPR_SEQ" ).append("\n"); 
		query.append("        ,SHPR_KW_NM" ).append("\n"); 
		query.append("        ,FWRD_CNT_CD" ).append("\n"); 
		query.append("        ,FWRD_SEQ" ).append("\n"); 
		query.append("        ,FWRD_KW_NM" ).append("\n"); 
		query.append("        ,CNEE_CNT_CD" ).append("\n"); 
		query.append("        ,CNEE_SEQ" ).append("\n"); 
		query.append("        ,CNEE_KW_NM" ).append("\n"); 
		query.append("        ,POR_CD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,CMDT_CD" ).append("\n"); 
		query.append("        ,INTER_XTER_RMK_KW_NM" ).append("\n"); 
		query.append("        ,CNTR_MF_GDS_DESC_KW_NM" ).append("\n"); 
		query.append("        ,CMDT_DESC_KW_NM" ).append("\n"); 
		query.append("        ,CSTMS_DESC_KW_NM" ).append("\n"); 
		query.append("        ,CUST_DESC_KW_NM" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("	    ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[blck_kw_tp_cd]" ).append("\n"); 
		query.append("       ,NVL((select max(BLCK_KW_TP_SEQ) from BKG_BLCK_LIST_MNTR WHERE BLCK_KW_TP_CD = @[blck_kw_tp_cd] ),0)+1" ).append("\n"); 
		query.append("       ,@[bkg_no]" ).append("\n"); 
		query.append("       ,@[blck_kw_nm]" ).append("\n"); 
		query.append("       ,BL_NO" ).append("\n"); 
		query.append("       ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("       ,CTRT_OFC_CD" ).append("\n"); 
		query.append("       ,(select sum(OP_CNTR_QTY) from bkg_quantity where bkg_no = @[bkg_no] and CNTR_TPSZ_CD not like 'Q%' and rownum=1)" ).append("\n"); 
		query.append("       ,(select CUST_CNT_CD from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'S' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_SEQ from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'S' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_NM from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'S' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_CNT_CD from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'F' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_SEQ from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'F' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_NM from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'F' and rownum =1)" ).append("\n"); 
		query.append("	   ,(select CUST_CNT_CD from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'C' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_SEQ from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'C' and rownum =1)" ).append("\n"); 
		query.append("       ,(select CUST_NM from bkg_customer where bkg_no = @[bkg_no] and BKG_CUST_TP_CD = 'C' and rownum =1)" ).append("\n"); 
		query.append("	   ,POR_CD" ).append("\n"); 
		query.append("       ,POL_CD" ).append("\n"); 
		query.append("       ,POD_CD" ).append("\n"); 
		query.append("       ,DEL_CD" ).append("\n"); 
		query.append("       ,CMDT_CD" ).append("\n"); 
		query.append("       ,@[inter_xter_rmk_kw_nm]" ).append("\n"); 
		query.append("	   ,@[cntr_mf_gds_desc_kw_nm]" ).append("\n"); 
		query.append("	   ,@[cmdt_desc_kw_nm]" ).append("\n"); 
		query.append("	   ,@[cstms_desc_kw_nm]" ).append("\n"); 
		query.append("	   ,@[cust_desc_kw_nm]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,sysdate" ).append("\n"); 
		query.append("	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("	   ,sysdate" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}