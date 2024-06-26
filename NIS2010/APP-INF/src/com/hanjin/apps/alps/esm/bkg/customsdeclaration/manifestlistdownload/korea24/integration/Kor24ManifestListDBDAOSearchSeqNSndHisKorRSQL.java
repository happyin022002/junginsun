/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchSeqNSndHisKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.20 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchSeqNSndHisKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * B/L의 sequence와 전송여부를 구하고 데이터 존재하면 에러메시지를 Return한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchSeqNSndHisKorRSQL(){
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
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchSeqNSndHisKorRSQL").append("\n");
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
		query.append("SELECT NVL(TRNS_SEQ,0) KT_SEQ" ).append("\n");
		query.append(", DECODE(MF_SND_DT, NULL, 0, 1) KT_SND_DT_CHK" ).append("\n");
		query.append("FROM   BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND    TRNS_SEQ = (SELECT NVL(MAX(TRNS_SEQ),0)" ).append("\n");
		query.append("FROM   BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port])" ).append("\n");

	}
}