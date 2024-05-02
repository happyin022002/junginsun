/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAORemoveFinanceOfficeInfoTempListDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.23 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAORemoveFinanceOfficeInfoTempListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_OFC_INFO_TMP 테이블에서 데이터를 삭제한다.
	  * </pre>
	  */
	public ACMSetupDBDAORemoveFinanceOfficeInfoTempListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tmp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration ").append("\n");
		query.append("FileName : ACMSetupDBDAORemoveFinanceOfficeInfoTempListDSQL").append("\n");
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
		query.append("DELETE FROM ACM_OFC_INFO_TMP" ).append("\n");
		query.append("WHERE OFC_TMP_NO = @[ofc_tmp_no]" ).append("\n");

	}
}