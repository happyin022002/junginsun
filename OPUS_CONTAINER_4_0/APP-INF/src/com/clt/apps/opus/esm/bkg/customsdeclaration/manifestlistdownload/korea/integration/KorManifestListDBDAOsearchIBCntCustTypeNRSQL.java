/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIBCntCustTypeNRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.18 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchIBCntCustTypeNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchIBCntCustTypeC에서 cnt_cd의 값이 " " (값이 없을 경우) 일 경우 Type N을 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIBCntCustTypeNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchIBCntCustTypeNRSQL").append("\n");
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
		query.append("SELECT NVL(CNT_CD,' ') CUST_CNT_CD" ).append("\n");
		query.append(", NVL(CUST_SEQ,0) CUST_SEQ" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CUST" ).append("\n");
		query.append("WHERE (BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, TRNS_SEQ, BKG_CUST_TP_CD) IN" ).append("\n");
		query.append("(SELECT BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ), 'N'" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND    NVL(DELT_FLG,'N') = 'N'" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD)" ).append("\n");

	}
}