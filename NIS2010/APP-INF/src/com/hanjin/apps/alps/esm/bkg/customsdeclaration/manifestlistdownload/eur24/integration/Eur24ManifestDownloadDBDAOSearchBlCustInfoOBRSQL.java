/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchBlCustInfoOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.09 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchBlCustInfoOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_IO_CUST table의 Customer정보를 VVD와 BL No.로 검색해 오는 SQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchBlCustInfoOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchBlCustInfoOBRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("S.BL_NO BL_NO," ).append("\n"); 
		query.append("S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("S.CSTMS_PORT_CD CSTMS_PORT_CD," ).append("\n"); 
		query.append("S.BKG_CUST_TP_CD S_BKG_CUST_TP_CD," ).append("\n"); 
		query.append("S.CUST_CNT_CD S_CUST_CNT_CD," ).append("\n"); 
		query.append("S.CUST_SEQ S_CUST_SEQ," ).append("\n"); 
		query.append("S.CUST_NM S_CUST_NM," ).append("\n"); 
		query.append("S.CUST_ADDR S_CUST_ADDR," ).append("\n"); 
		query.append("S.CUST_CTY_NM S_CUST_CTY_NM," ).append("\n"); 
		query.append("S.CSTMS_DECL_CNT_CD S_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append("S.CUST_ZIP_ID S_CUST_ZIP_ID," ).append("\n"); 
		query.append("S.EUR_CSTMS_ST_NM S_EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("S.EORI_NO S_EORI_NO," ).append("\n"); 
		query.append("DECODE(S.BL_NO, '', 'I', 'U') S_IBFLAG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("F.BKG_CUST_TP_CD F_BKG_CUST_TP_CD," ).append("\n"); 
		query.append("F.CUST_CNT_CD F_CUST_CNT_CD," ).append("\n"); 
		query.append("F.CUST_SEQ F_CUST_SEQ," ).append("\n"); 
		query.append("F.CUST_NM F_CUST_NM," ).append("\n"); 
		query.append("F.CUST_ADDR F_CUST_ADDR," ).append("\n"); 
		query.append("F.CUST_CTY_NM F_CUST_CTY_NM," ).append("\n"); 
		query.append("F.CSTMS_DECL_CNT_CD F_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append("F.CUST_ZIP_ID F_CUST_ZIP_ID," ).append("\n"); 
		query.append("F.EUR_CSTMS_ST_NM F_EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("F.EORI_NO F_EORI_NO," ).append("\n"); 
		query.append("DECODE(F.BL_NO, '', 'I', 'U') F_IBFLAG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("C.BKG_CUST_TP_CD C_BKG_CUST_TP_CD," ).append("\n"); 
		query.append("C.CUST_CNT_CD C_CUST_CNT_CD," ).append("\n"); 
		query.append("C.CUST_SEQ C_CUST_SEQ," ).append("\n"); 
		query.append("C.CUST_NM C_CUST_NM," ).append("\n"); 
		query.append("C.CUST_ADDR C_CUST_ADDR," ).append("\n"); 
		query.append("C.CUST_CTY_NM C_CUST_CTY_NM," ).append("\n"); 
		query.append("C.CSTMS_DECL_CNT_CD C_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append("C.CUST_ZIP_ID C_CUST_ZIP_ID," ).append("\n"); 
		query.append("C.EUR_CSTMS_ST_NM C_EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("C.EORI_NO C_EORI_NO," ).append("\n"); 
		query.append("DECODE(C.BL_NO, '', 'I', 'U') C_IBFLAG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("N.BKG_CUST_TP_CD N_BKG_CUST_TP_CD," ).append("\n"); 
		query.append("N.CUST_CNT_CD N_CUST_CNT_CD," ).append("\n"); 
		query.append("N.CUST_SEQ N_CUST_SEQ," ).append("\n"); 
		query.append("N.CUST_NM N_CUST_NM," ).append("\n"); 
		query.append("N.CUST_ADDR N_CUST_ADDR," ).append("\n"); 
		query.append("N.CUST_CTY_NM N_CUST_CTY_NM," ).append("\n"); 
		query.append("N.CSTMS_DECL_CNT_CD N_CSTMS_DECL_CNT_CD," ).append("\n"); 
		query.append("N.CUST_ZIP_ID N_CUST_ZIP_ID," ).append("\n"); 
		query.append("N.EUR_CSTMS_ST_NM N_EUR_CSTMS_ST_NM," ).append("\n"); 
		query.append("N.EORI_NO N_EORI_NO," ).append("\n"); 
		query.append("DECODE(N.BL_NO, '', 'I', 'U') N_IBFLAG" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_IO_CUST S, BKG_CSTMS_EUR_IO_CUST F, BKG_CSTMS_EUR_IO_CUST C, BKG_CSTMS_EUR_IO_CUST N" ).append("\n"); 
		query.append("WHERE S.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND S.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND S.CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("AND S.CSTMS_PORT_CD = F.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("AND S.CSTMS_PORT_CD = C.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("AND S.CSTMS_PORT_CD = N.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND F.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("AND S.BL_NO = F.BL_NO(+)" ).append("\n"); 
		query.append("AND S.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("AND S.BL_NO = N.BL_NO(+)" ).append("\n"); 
		query.append("AND S.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND F.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND C.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND N.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("AND S.VSL_CD = F.VSL_CD(+)" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = F.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = F.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND S.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND S.VSL_CD = N.VSL_CD(+)" ).append("\n"); 
		query.append("AND S.SKD_VOY_NO = N.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND S.SKD_DIR_CD = N.SKD_DIR_CD(+)" ).append("\n"); 

	}
}