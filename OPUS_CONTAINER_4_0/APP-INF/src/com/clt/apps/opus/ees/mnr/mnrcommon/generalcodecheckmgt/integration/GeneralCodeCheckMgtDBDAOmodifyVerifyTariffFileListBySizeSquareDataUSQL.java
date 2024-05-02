/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListBySizeSquareDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.22 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListBySizeSquareDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정 - Tariff File Verify SizeSquare
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListBySizeSquareDataUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListBySizeSquareDataUSQL").append("\n"); 
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
		query.append("SET A.INP_MSG4 = 'SE'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND A.INP_MSG10 = 'F'" ).append("\n"); 
		query.append("AND A.INP_MSG11 IN ('Z','S')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("TO_NUMBER(A.INP_MSG13) < TO_NUMBER(NVL(A.INP_MSG8,0))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("TO_NUMBER(A.INP_MSG13) > TO_NUMBER(NVL(A.INP_MSG9,0))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}