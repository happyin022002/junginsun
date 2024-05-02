/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestDownloadDBDAOsearchManifestContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DominicanManifestDownloadDBDAOsearchManifestContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container 정보 조회
	  * </pre>
	  */
	public DominicanManifestDownloadDBDAOsearchManifestContainerRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration").append("\n"); 
		query.append("FileName : DominicanManifestDownloadDBDAOsearchManifestContainerRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("     BK.BL_NO" ).append("\n"); 
		query.append("    ,BC.CNTR_NO Container_No " ).append("\n"); 
		query.append("    ,BV.POD_YD_CD  Placa_No" ).append("\n"); 
		query.append("    ,BC.CNTR_TPSZ_CD Container_Type" ).append("\n"); 
		query.append("    ,BC.PCK_TP_CD Package_Code" ).append("\n"); 
		query.append("    ,'' AMOUNT" ).append("\n"); 
		query.append("    ,DECODE(NVL(BC.WGT_UT_CD,' '),'LBS',ROUND(NVL(BC.CNTR_WGT,0)*0.4536,2),NVL(BC.CNTR_WGT,0)) Gross_Weight" ).append("\n"); 
		query.append("    ,'' Net_Weight" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_SEAL_SEQ = 1" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) Seal_No1    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_SEAL_SEQ = 2" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) Seal_No2    " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("     BKG_BOOKING     BK" ).append("\n"); 
		query.append("    ,BKG_VVD         BV" ).append("\n"); 
		query.append("    ,BKG_CONTAINER   BC " ).append("\n"); 
		query.append("    ,BKG_RF_CGO     BRC " ).append("\n"); 
		query.append("    ,BKG_AWK_CGO    BAC " ).append("\n"); 
		query.append("    ,BKG_BB_CGO     BBC " ).append("\n"); 
		query.append("    ,MST_CONTAINER  MC " ).append("\n"); 
		query.append("    ,MDM_CNTR_TP_SZ MCTS " ).append("\n"); 
		query.append("WHERE BV.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND NVL(BK.BKG_STS_CD, ' ') NOT IN ('S', 'X','A')" ).append("\n"); 
		query.append("AND  BK.BKG_NO          =   BV.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO          =   BC.BKG_NO" ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BRC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BRC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BAC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   BAC.CNTR_NO      (+) " ).append("\n"); 
		query.append("AND  BC.BKG_NO          =   BBC.BKG_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_NO         =   MC.CNTR_NO       (+) " ).append("\n"); 
		query.append("AND  BC.CNTR_TPSZ_CD    =   MCTS.CNTR_TPSZ_CD (+)" ).append("\n"); 

	}
}