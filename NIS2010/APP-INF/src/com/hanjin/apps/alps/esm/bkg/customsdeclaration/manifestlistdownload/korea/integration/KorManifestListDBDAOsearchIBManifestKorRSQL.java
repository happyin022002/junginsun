/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIBManifestKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.06 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchIBManifestKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManifestKor 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIBManifestKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchIBManifestKorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT O.BL_NO BL_NO" ).append("\n"); 
		query.append(", O.BKG_NO BKG_NO" ).append("\n"); 
		query.append(", NVL(I.PCK_QTY,0) PKG_VALUE" ).append("\n"); 
		query.append(", NVL(I.PCK_TP_CD,'  ') PKG_CODE" ).append("\n"); 
		query.append(", NVL(I.CNTR_TTL_WGT,0) WGT_VALUE" ).append("\n"); 
		query.append(", NVL(I.WGT_UT_CD,'   ') WGT_CODE" ).append("\n"); 
		query.append(", DECODE(I.BKG_NO,NULL,' ', DECODE(O.PCK_QTY,I.PCK_QTY, DECODE(O.PCK_TP_CD,I.PCK_TP_CD, DECODE(O.CNTR_TTL_WGT,I.CNTR_TTL_WGT, DECODE(O.WGT_UT_CD,I.WGT_UT_CD,'Y','N'),'N'),'N'),'N')) MATCH" ).append("\n"); 
		query.append(", NVL(I.VSL_CD,' ')||NVL(I.SKD_VOY_NO,' ')||NVL(I.SKD_DIR_CD,' ') PRE_VVD" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_BL O, BKG_CSTMS_KR_BL I" ).append("\n"); 
		query.append("WHERE  O.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("AND    O.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("AND    O.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("AND    O.BKG_NO     = @[a_bkg_no]" ).append("\n"); 
		query.append("AND    O.CSTMS_DECL_TP_CD = 'R'" ).append("\n"); 
		query.append("AND    O.TS_POL_CD = @[in_pol]" ).append("\n"); 
		query.append("AND    O.BKG_NO = I.BKG_NO(+)" ).append("\n"); 
		query.append("AND    O.CSTMS_BL_NO = I.CSTMS_BL_NO(+)" ).append("\n"); 
		query.append("AND    O.DMST_PORT_CD = I.DMST_PORT_CD(+)" ).append("\n"); 
		query.append("AND    I.CSTMS_DECL_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("AND    I.MF_SND_DT  IS NOT NULL" ).append("\n"); 
		query.append("AND    O.MF_SND_DT  IS NULL" ).append("\n"); 

	}
}