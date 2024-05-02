/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchDownHistChkForRtvRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.23 박상훈
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

public class Kor24ManifestListDBDAOsearchDownHistChkForRtvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 최초 다운인지 여부를 판단하여 기존에 다운된 데이터가 있을 경우엔 BKG 테이블상의 Cancel된 데이터를 포함하는 list를 조회하도록 한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchDownHistChkForRtvRSQL(){
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
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchDownHistChkForRtvRSQL").append("\n");
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
		query.append("SELECT COUNT(*) CNT" ).append("\n");
		query.append("FROM BKG_CSTMS_ADV_KR_BL" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND DECODE(@[in_bound], 'I', TS_POD_CD, TS_POL_CD)  = DECODE(@[in_bound], 'I', @[pod_loc], @[pol_loc])" ).append("\n");
		query.append("#if(${in_bound}!='O')" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('I', 'T')" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD IN ('E', 'R')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND DMST_PORT_CD = @[kt_port]" ).append("\n");

	}
}