/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchMultiBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.14 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchMultiBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlMultiBlListVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchMultiBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchMultiBlListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("        C.BL_NO " ).append("\n"); 
		query.append("       ,CONCAT('0',C.CSTMS_FILE_TP_CD) AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("       ,DECODE(E.FRT_CLT_FLG || '/' || E.OBL_RDEM_FLG || '/' || E.CSTMS_CLR_CD, '//', ''" ).append("\n"); 
		query.append("              ,E.FRT_CLT_FLG || '/' || E.OBL_RDEM_FLG || '/' || E.CSTMS_CLR_CD) AS FOC" ).append("\n"); 
		query.append("       ,C.PCK_QTY" ).append("\n"); 
		query.append("       ,C.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,I.IBD_TRSP_NO" ).append("\n"); 
		query.append("       ,C.HUB_LOC_CD" ).append("\n"); 
		query.append("       ,C.USA_LST_LOC_CD" ).append("\n"); 
		query.append("       ,C.DEL_CD" ).append("\n"); 
		query.append("       ,G.CNTR_NO" ).append("\n"); 
		query.append("       ,G.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,REPLACE(F.CUST_NM, CHR(13)||CHR(10), ' ') AS CNEE" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_CNTR A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CNTR B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_BL D" ).append("\n"); 
		query.append("       ,BKG_CGO_RLSE E" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST F" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CNTR G" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     D.CNT_CD        =   @[cnt_cd]" ).append("\n"); 
		query.append("AND     D.BL_NO         =   @[bl_no]" ).append("\n"); 
		query.append("AND     A.CNT_CD        =   D.CNT_CD" ).append("\n"); 
		query.append("AND     A.BL_NO         =   D.BL_NO" ).append("\n"); 
		query.append("AND     A.BL_NO         <>  C.BL_NO" ).append("\n"); 
		query.append("AND     B.CNT_CD        =   C.CNT_CD" ).append("\n"); 
		query.append("AND     B.BL_NO         =   C.BL_NO" ).append("\n"); 
		query.append("AND     A.CNTR_NO       =   B.CNTR_NO" ).append("\n"); 
		query.append("AND     C.VSL_CD        =   D.VSL_CD" ).append("\n"); 
		query.append("AND     C.SKD_VOY_NO    =   D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     C.SKD_DIR_CD    =   D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     C.POD_CD        =   D.POD_CD" ).append("\n"); 
		query.append("AND     C.MF_STS_CD     =   'A'" ).append("\n"); 
		query.append("AND     C.MF_NO         IS  NULL" ).append("\n"); 
		query.append("AND     C.CNT_CD        =   F.CNT_CD" ).append("\n"); 
		query.append("AND     C.BL_NO         =   F.BL_NO" ).append("\n"); 
		query.append("AND     C.BL_NO         =   F.BL_NO" ).append("\n"); 
		query.append("AND     F.BKG_CUST_TP_CD=   'C'" ).append("\n"); 
		query.append("AND     C.BL_NO         =   E.BL_NO(+)" ).append("\n"); 
		query.append("AND     C.CNT_CD        =   G.CNT_CD(+)" ).append("\n"); 
		query.append("AND     C.BL_NO         =   G.BL_NO(+)" ).append("\n"); 
		query.append("AND     C.CNT_CD        =   I.CNT_CD" ).append("\n"); 
		query.append("AND     C.BL_NO         =   I.BL_NO" ).append("\n"); 

	}
}