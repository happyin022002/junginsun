/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlVVDListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlVVDListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI data에서 VVD를 추출하여 정규 Invoice로 옮기기
	  * </pre>
	  */
	public TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlVVDListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlVVDListCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("INSERT INTO TES_TML_SO_VVD_LIST(" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_SO_SEQ" ).append("\n"); 
		query.append(", TML_SO_VVD_LIST_SEQ" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", ATB_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[tml_so_seq]" ).append("\n"); 
		query.append(", ROWNUM" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", ATB_DT" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  SUBSTR(A.VVD_CD,1,4) VSL_CD" ).append("\n"); 
		query.append(", SUBSTR(A.VVD_CD,5,4) SKD_VOY_NO" ).append("\n"); 
		query.append(", SUBSTR(A.VVD_CD,9) SKD_DIR_CD" ).append("\n"); 
		query.append(", DECODE(A.IO_IND_CD,'B','I',A.IO_IND_CD) IO_BND_CD" ).append("\n"); 
		query.append(", V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", (SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM	TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND H.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.IB_VVD_CD)=9" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND H.IB_VVD_CD <> H.OB_VVD_CD)  A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(A.VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(A.VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(A.VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(A.VVD_CD,9)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  SUBSTR(A.VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(A.IO_IND_CD,'B','I',A.IO_IND_CD) IO_BND_CD," ).append("\n"); 
		query.append("LAST_DAY(TO_DATE(SUBSTR(A.VVD_CD,5,4),'YYMM')) ATB_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.IB_VVD_CD)=9" ).append("\n"); 
		query.append("AND SUBSTR(H.IB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND H.IB_VVD_CD <> H.OB_VVD_CD" ).append("\n"); 
		query.append("AND SUBSTR(H.OB_VVD_CD,1,4) = 'CNTC') A" ).append("\n"); 
		query.append("WHERE SUBSTR(A.TML_INV_TP_CD,1,1) = 'M'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  SUBSTR(A.VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(A.IO_IND_CD,'B','O',A.IO_IND_CD) IO_BND_CD," ).append("\n"); 
		query.append("V.VPS_ETB_DT ATB_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("(SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.IB_VVD_CD)=9" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND H.IB_VVD_CD <> H.OB_VVD_CD)  A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(A.VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(A.VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(A.VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(A.VVD_CD,9)" ).append("\n"); 
		query.append("AND A.IO_IND_CD IS NOT NULL AND A.IO_IND_CD = 'B'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  SUBSTR(A.VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(A.VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(A.IO_IND_CD,'B','O',A.IO_IND_CD) IO_BND_CD," ).append("\n"); 
		query.append("LAST_DAY(TO_DATE(SUBSTR(A.VVD_CD,5,4),'YYMM')) ATB_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.IB_VVD_CD)=9" ).append("\n"); 
		query.append("AND SUBSTR(H.IB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD LIKE 'M%'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND H.IB_VVD_CD <> H.OB_VVD_CD" ).append("\n"); 
		query.append("AND SUBSTR(H.OB_VVD_CD,1,4) = 'CNTC') A" ).append("\n"); 
		query.append("WHERE SUBSTR(A.TML_INV_TP_CD,1,1) = 'M'" ).append("\n"); 
		query.append("AND A.IO_IND_CD IS NOT NULL AND A.IO_IND_CD = 'B'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A.VSL_CD VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("A.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("--		/**  [CHM-200901475] 20091029: 부신신항의 VVD구하기에서 VSK_VSL_PORT_SKD의 Calling port indicator가 복수인 경우 VVD가 복수로 생성되어 Group화 처리되어 ATB DATE는 MIN값으로 대체  **/" ).append("\n"); 
		query.append("MIN(V.VPS_ETB_DT) ATB_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("(SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append(", D.VSL_CD" ).append("\n"); 
		query.append(", D.SKD_VOY_NO" ).append("\n"); 
		query.append(", D.SKD_DIR_CD" ).append("\n"); 
		query.append(", D.IO_BND_CD" ).append("\n"); 
		query.append("FROM	TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('180020','186666','176307')" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("AND D.VSL_CD IS NOT NULL AND D.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append(", D.VSL_CD" ).append("\n"); 
		query.append(", D.SKD_VOY_NO" ).append("\n"); 
		query.append(", D.SKD_DIR_CD" ).append("\n"); 
		query.append(", D.IO_BND_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_CNTR_LIST D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('180020','186666','176307')" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("AND D.VSL_CD IS NOT NULL AND D.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append(")  A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND V.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("--		/**  [CHM-200901475] 20091029: 부신신항의 VVD구하기에서 VSK_VSL_PORT_SKD의 Calling port indicator가 복수인 경우 VVD가 복수로 생성되어 Group화 처리  **/" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A.VSL_CD VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("A.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("A.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("LAST_DAY(TO_DATE(A.SKD_VOY_NO,'YYMM')) ATB_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append(", D.VSL_CD" ).append("\n"); 
		query.append(", D.SKD_VOY_NO" ).append("\n"); 
		query.append(", D.SKD_DIR_CD" ).append("\n"); 
		query.append(", D.IO_BND_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('180020','186666','176307')" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("AND D.VSL_CD IS NOT NULL AND D.VSL_CD = 'CNTC'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append(", D.VSL_CD" ).append("\n"); 
		query.append(", D.SKD_VOY_NO" ).append("\n"); 
		query.append(", D.SKD_DIR_CD" ).append("\n"); 
		query.append(", D.IO_BND_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_CNTR_LIST D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--		// Table Join 조건이 누락되어서 조건 추가 ( 2009-11-20 )" ).append("\n"); 
		query.append("--		// EDI INVOICE전환시 VVD LIST 조회 조건 로직 수정" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD	= D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ			= D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('180020','186666','176307')" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("AND D.VSL_CD IS NOT NULL AND D.VSL_CD = 'CNTC') A" ).append("\n"); 
		query.append("--	20091211 쿼리추가" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}