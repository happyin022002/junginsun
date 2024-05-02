/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchConditionForVGMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchConditionForVGMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VGM 데이터를 받기 위한 조건 검색 (추후 터미널, 나라별로 조건 추가 가능성 있음)
	  * 
	  * 1. CTM에서 온 VGM_WGT가 BKG CNTR Weight보다 값이 큰지 검사
	  * 2. REV bkg일 때는 wgt가 같은 것도 허용
	  * 3. T2, T4일 때는 wgt가 같은것도 허용
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchConditionForVGMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("partial_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchConditionForVGMRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN NVL(A.VGM_WGT,0) = 0 AND WGT.FLG = 'Y' THEN 'Y' ELSE 'N' END FLG          " ).append("\n"); 
		query.append("FROM BKG_CONTAINER A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("            SELECT  BKG_NO" ).append("\n"); 
		query.append("                   ,CNTR_NO" ).append("\n"); 
		query.append("                   ,CASE WHEN 'R' <> (SELECT BKG_CGO_TP_CD FROM BKG_BOOKING WHERE BKG_NO = CNTR.BKG_NO) " ).append("\n"); 
		query.append("                             AND (" ).append("\n"); 
		query.append("                                    (NVL(CNTR.CNTR_WGT,0) = 0 OR CNTR.WGT_UT_CD IS NULL) " ).append("\n"); 
		query.append("                                    OR (NVL(CNTR.CNTR_WGT,0) < NVL(@[vgm_wgt_qty],0))" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                         WHEN ('R' = (SELECT BKG_CGO_TP_CD FROM BKG_BOOKING WHERE BKG_NO = CNTR.BKG_NO) OR CNTR.CNTR_TPSZ_CD IN ('T2','T4'))" ).append("\n"); 
		query.append("                             AND (" ).append("\n"); 
		query.append("                                    (NVL(CNTR.CNTR_WGT,0) = 0 OR CNTR.WGT_UT_CD IS NULL) " ).append("\n"); 
		query.append("                                    OR (NVL(CNTR.CNTR_WGT,0) <= NVL(@[vgm_wgt_qty],0))" ).append("\n"); 
		query.append("                                 )    " ).append("\n"); 
		query.append("                             THEN 'Y' ELSE 'N' END FLG   " ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[partial_bkg_no]" ).append("\n"); 
		query.append("            AND CNTR_NO = @[cntr_no]         " ).append("\n"); 
		query.append("        )  WGT        " ).append("\n"); 
		query.append("WHERE A.BKG_NO = WGT.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = WGT.CNTR_NO" ).append("\n"); 

	}
}