/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementDBDAODeleteFFAgreementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.09 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAgreementDBDAODeleteFFAgreementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteFFAgreement
	  * </pre>
	  */
	public FFCmpnAgreementDBDAODeleteFFAgreementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.integration ").append("\n"); 
		query.append("FileName : FFCmpnAgreementDBDAODeleteFFAgreementUSQL").append("\n"); 
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
		query.append("UPDATE ACM_FF_AGMT" ).append("\n"); 
		query.append("   SET  DELT_FLG = 'Y'," ).append("\n"); 
		query.append("        UPD_USR_ID 			= @[usr_id]," ).append("\n"); 
		query.append("        UPD_DT 				= SYSDATE" ).append("\n"); 
		query.append(" WHERE FF_CNT_CD = SUBSTR(@[ff_cnt_seq],0,2)" ).append("\n"); 
		query.append("   AND FF_SEQ = TO_NUMBER(SUBSTR(@[ff_cnt_seq],3))" ).append("\n"); 
		query.append("   AND FF_AGMT_SEQ = @[ff_agmt_seq]" ).append("\n"); 

	}
}