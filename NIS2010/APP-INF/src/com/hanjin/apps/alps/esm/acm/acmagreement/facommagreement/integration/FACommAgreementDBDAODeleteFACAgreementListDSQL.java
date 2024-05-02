/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAODeleteFACAgreementListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.08 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAODeleteFACAgreementListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_FAC_AGMT 에서 데이터 삭제
	  * </pre>
	  */
	public FACommAgreementDBDAODeleteFACAgreementListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration ").append("\n"); 
		query.append("FileName : FACommAgreementDBDAODeleteFACAgreementListDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM   ACM_FAC_AGMT" ).append("\n"); 
		query.append("WHERE  FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n"); 
		query.append("AND    FF_CNT_CD = @[ff_cnt_cd]" ).append("\n"); 
		query.append("AND    FF_SEQ = @[ff_seq]" ).append("\n"); 
		query.append("AND    FAC_AGMT_SEQ = @[fac_agmt_seq]" ).append("\n"); 

	}
}