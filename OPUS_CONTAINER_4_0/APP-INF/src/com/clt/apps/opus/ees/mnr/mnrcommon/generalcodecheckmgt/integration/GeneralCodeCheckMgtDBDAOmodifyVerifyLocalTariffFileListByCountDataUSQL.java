/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByCountDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.03.24 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByCountDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Verify - [EES_MNR_0190] 수정된 Local Tariff Data 의 Count 와 해당 Standard Tariff Data 의 Count 를 Verify 한다.
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByCountDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByCountDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET A.INP_MSG4 = 'CU'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ =@[tmp_seq]" ).append("\n"); 
		query.append("AND (SELECT COUNT(*) FROM MNR_DAT_VRFY WHERE TMP_SEQ = @[tmp_seq])" ).append("\n"); 
		query.append("<>" ).append("\n"); 
		query.append("(SELECT COUNT(*) FROM MNR_RPR_TRF_DTL WHERE TRF_NO = @[std_trf_no])" ).append("\n"); 

	}
}