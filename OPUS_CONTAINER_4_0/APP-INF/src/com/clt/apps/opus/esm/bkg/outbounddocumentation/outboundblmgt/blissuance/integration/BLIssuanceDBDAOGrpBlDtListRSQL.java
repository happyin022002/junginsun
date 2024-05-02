/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOGrpBlDtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.01.06 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOGrpBlDtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOGrpBlDtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rlse_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOGrpBlDtListRSQL").append("\n"); 
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
		query.append("SELECT T1.BKG_NO" ).append("\n"); 
		query.append(",      T1.BL_NO" ).append("\n"); 
		query.append(",      NVL(T2.BL_ISS_TP_CD,'B') BL_ISS_TP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD||LPAD (CUST_SEQ, 5, '0') FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='S') CUST_CD" ).append("\n"); 
		query.append(",      (SELECT REPLACE(REPLACE(CUST_NM, CHR(10), ''), CHR(13), ' ') FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='S') CUST_NM" ).append("\n"); 
		query.append(",      T1.BL_OBRD_TP_CD" ).append("\n"); 
		query.append(",      TO_CHAR (T1.BL_OBRD_DT, 'YYYY-MM-DD') BL_OBRD_DT" ).append("\n"); 
		query.append(",      '' BL_OBRD_DT_SD" ).append("\n"); 
		query.append(",      NVL(T2.OBL_ISS_FLG,'N') OBL_ISS_FLG" ).append("\n"); 
		query.append(",       NVL(T2.OBL_RLSE_FLG,'N') OBL_RLSE_FLG" ).append("\n"); 
		query.append(",      TO_CHAR (T2.OBL_ISS_DT, 'YYYY-MM-DD') OBL_ISS_DT" ).append("\n"); 
		query.append(",      '' OBL_ISS_DT_SD" ).append("\n"); 
		query.append(",      T2.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(",      T2.OBL_ISS_USR_ID" ).append("\n"); 
		query.append(",      T2.CRE_USR_ID" ).append("\n"); 
		query.append(",      T2.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   (SELECT BKG_NO" ).append("\n"); 
		query.append(",              BL_NO" ).append("\n"); 
		query.append(",              BL_TP_CD" ).append("\n"); 
		query.append(",              BL_OBRD_TP_CD" ).append("\n"); 
		query.append(",              BL_OBRD_DT" ).append("\n"); 
		query.append("        FROM   (SELECT A.BKG_NO" ).append("\n"); 
		query.append(",                      A.BL_NO" ).append("\n"); 
		query.append(",                      A.BL_TP_CD" ).append("\n"); 
		query.append(",                      B.BL_OBRD_TP_CD" ).append("\n"); 
		query.append(",                      B.BL_OBRD_DT" ).append("\n"); 
		query.append(",                      ROW_NUMBER() OVER (PARTITION BY A.BKG_NO ORDER BY C.VSL_PRE_PST_CD || C.VSL_SEQ) AS NUM" ).append("\n"); 
		query.append("                FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_VVD C" ).append("\n"); 
		query.append("                WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                AND    B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                AND    A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                AND    A.POL_CD = C.POL_CD" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND    A.BKG_OFC_CD= @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                AND    A.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${shipper_cd} != '')" ).append("\n"); 
		query.append("                AND    A.BKG_NO IN (SELECT BKG_NO FROM BKG_CUSTOMER WHERE CUST_CNT_CD=@[cust_cnt_cd] AND CUST_SEQ=@[cust_seq] AND BKG_CUST_TP_CD='S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND    C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                AND    C.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                AND    C.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                AND    C.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                ORDER BY C.VSL_PRE_PST_CD, C.VSL_SEQ)" ).append("\n"); 
		query.append("        WHERE  NUM = 1) T1, BKG_BL_ISS T2" ).append("\n"); 
		query.append("WHERE  T1.BKG_NO = T2.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${obl_iss_flg} == 'Y') " ).append("\n"); 
		query.append("AND    @[obl_iss_flg] = T2.OBL_ISS_FLG " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_rlse_flg} == 'Y')" ).append("\n"); 
		query.append("AND    @[obl_rlse_flg] = T2.OBL_RLSE_FLG " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${obl_iss_flg} == 'N') " ).append("\n"); 
		query.append("AND    (@[obl_iss_flg] = T2.OBL_ISS_FLG OR T2.BKG_NO IS NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_rlse_flg} == 'N')" ).append("\n"); 
		query.append("AND    (@[obl_rlse_flg] = T2.OBL_RLSE_FLG OR T2.OBL_RLSE_FLG IS NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}