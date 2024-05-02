/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 FLATFILE 전송 시 기본 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchDeclBaseInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" '89N'  DOC_CD" ).append("\n"); 
		query.append(",  'IFTDGN' || @[vvd_cd] || @[port_cd] || @[d_type]|| LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'0000009')) DOC_NO" ).append("\n"); 
		query.append(",'' MSG_FUNC" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', SYSDATE, @[ofc_cd]),'YYYYMMHH24MI') MSG_DATE " ).append("\n"); 
		query.append(",A.DG_DECL_TP_CD  HANDLING" ).append("\n"); 
		query.append(",(	SELECT	MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_DG_SND" ).append("\n"); 
		query.append("	WHERE CNT_CD = 'AU'" ).append("\n"); 
		query.append("	AND	  DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("	AND   VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	AND   PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append(") REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'20' TRANS_STAGE" ).append("\n"); 
		query.append(",((A.SKD_VOY_NO) || (A.SKD_DIR_CD))AS VOYAGE_NO" ).append("\n"); 
		query.append(",'1' TRANS_MODE" ).append("\n"); 
		query.append(",C.LLOYD_NO IMO_NO" ).append("\n"); 
		query.append(",C.VSL_ENG_NM VESSEL_NM" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(",'MS' PARTY_TYPE" ).append("\n"); 
		query.append(",F.CRR_NM CARRIER_NM" ).append("\n"); 
		query.append(",'' DEPT_EMPLOY" ).append("\n"); 
		query.append(",'' COM_NO" ).append("\n"); 
		query.append(",'EM' COM_CH" ).append("\n"); 
		query.append(",NVL((" ).append("\n"); 
		query.append("	SELECT DECODE (MSG_SND_NO, NULL, 'O', 'U') " ).append("\n"); 
		query.append("	FROM BKG_CSTMS_DG_SND " ).append("\n"); 
		query.append("	WHERE DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("	AND   VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	AND   PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("	AND   CNT_CD        = 'AU' " ).append("\n"); 
		query.append("	AND	  ROWNUM = 1 ),'O') SEND_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("     BKG_CSTMS_DG A" ).append("\n"); 
		query.append("    ,BKG_DG_CGO B" ).append("\n"); 
		query.append("    ,BKG_CSTMS_DG_VSL_SKD C" ).append("\n"); 
		query.append("    ,MDM_VSL_CNTR D" ).append("\n"); 
		query.append("    ,MDM_CARRIER F" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("AND	A.CNTR_NO        = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD       = C.PORT_CD" ).append("\n"); 
		query.append("AND A.DG_DECL_TP_CD = C.DG_DECL_TP_CD" ).append("\n"); 
		query.append("AND A.CNT_CD        = C.CNT_CD" ).append("\n"); 
		query.append("AND C.VSL_ENG_NM    = D.VSL_ENG_NM " ).append("\n"); 
		query.append("AND D.CRR_CD        = F.CRR_CD" ).append("\n"); 
		query.append("AND A.CNT_CD        = 'AU'" ).append("\n"); 
		query.append("AND   ROWNUM        = 1" ).append("\n"); 

	}
}