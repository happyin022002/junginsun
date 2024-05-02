/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchRegNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.29 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchRegNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 만일 조회해서 데이타가 없을 경우 reg_no 를 'N'으로 설정한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchRegNoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

	}

	/**
	 *
	 */
	public String getSQL(){
		return query.toString();
	}

	/**
	 *
	 */
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DECODE(CUST_RGST_NO,NULL,'N','Y') BIZ_NO" ).append("\n");
		query.append("FROM MDM_CUSTOMER" ).append("\n");
		query.append("WHERE CUST_CNT_CD = @[cnt_cd]" ).append("\n");
		query.append("AND CUST_SEQ = @[cust_cd]" ).append("\n");
		query.append("AND LENGTH(CUST_RGST_NO) = 10" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchRegNoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}