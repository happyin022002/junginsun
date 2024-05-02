/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorManifestListDBDAOSearchBkgStsKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier :
*@LastVersion : 1.0
* 2011.03.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchBkgStsKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BKG Status 인자값에 cancel을 갖는것과  별개로 아래 쿼리에서 한국세관 테이블에 존재하는 BKG Status를 조회한다.
	  * 일종의 validation으로 여기서 조회한 값과 앞단의 status를 비교하여
	  * 같을 경우 즉 이미 Cancel된 BKG일 경우 Skip처리 한다.)
	  * pc표기 : if (strncmp((char *)kt_sts.arr, (char *)b_kt_sts.arr, 1) == 0)
	  *             {
	  *                 WriteLog("EDI_KRCUS_04_RP", "SKIP : KORCUS_TRANS already cancel (%s)(%s)(%s)(%s)(%s)\n",
	  *                         (char *)bkg_no.arr, (char *)bkg_no_split.arr, (char *)kcd_tp.arr, (char *)kt_port.arr, (char *)b_kt_sts.arr) ;
	  *                 TPRETURN("SKIP : KORCUS_TRANS already cancel !!", 0) ;
	  *             }
	  * </pre>
	  */
	public KorManifestListDBDAOSearchBkgStsKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchBkgStsKorRSQL").append("\n");
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
		query.append("SELECT TRNS_SEQ " ).append("\n");
		query.append(" 	 , KR_BL_AMDT_STS_CD " ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_BL " ).append("\n");
		query.append(" WHERE BKG_NO = @[bkg_no] " ).append("\n");
		query.append("   AND CSTMS_DECL_TP_CD = @[kcd_tp] " ).append("\n");
		query.append("   AND DMST_PORT_CD = @[kt_port] " ).append("\n");
		query.append("   AND TRNS_SEQ = (SELECT MAX(TRNS_SEQ) " ).append("\n");
		query.append("                     FROM BKG_CSTMS_KR_BL " ).append("\n");
		query.append("          		    WHERE BKG_NO = @[bkg_no] " ).append("\n");
		query.append(" 		              AND CSTMS_DECL_TP_CD = @[kcd_tp] " ).append("\n");
		query.append("	 	              AND DMST_PORT_CD = @[kt_port] " ).append("\n");
		query.append("		              AND MF_SND_DT IS NOT NULL" ).append("\n");
		query.append("                      AND DECODE(@[in_bound],'I',DECODE(NVL(PORT_TML_CD,' '),'KRPUSHN','KRPUSHN',' '),' ') = DECODE(@[in_bound],'I',DECODE(@[pod_tml],'KRPUSHN','KRPUSHN',' '),' ')" ).append("\n");
		query.append("                   )    " ).append("\n");
		query.append("   AND DECODE(@[in_bound],'I',DECODE(LENGTH(@[in_bound]),7,PORT_TML_CD,' '),' ') = DECODE(@[in_bound],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");

	}
}