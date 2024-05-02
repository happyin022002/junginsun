/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckValidationforIMDGClassUNNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCheckValidationforIMDGClassUNNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IMDG CLASS와 UN NO 유효성체크
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCheckValidationforIMDGClassUNNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckValidationforIMDGClassUNNoRSQL").append("\n"); 
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
		query.append("SELECT 	  	X.IMDG_CLSS_CD" ).append("\n"); 
		query.append("FROM      	SCG_IMDG_UN_NO    						X" ).append("\n"); 
		query.append("WHERE     	CASE 	WHEN @[cfr_flg] = 'Y' THEN '*'" ).append("\n"); 
		query.append("					ELSE X.IMDG_AMDT_NO" ).append("\n"); 
		query.append("			END										= CASE	WHEN @[cfr_flg] = 'Y' THEN '*'" ).append("\n"); 
		query.append("															ELSE @[imdg_amdt_no]" ).append("\n"); 
		query.append("													  END" ).append("\n"); 
		query.append("#if(${cfr_flg} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       X.IMDG_UN_NO      = @[cfr_no]" ).append("\n"); 
		query.append("AND		  X.CFR_FLG			= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       X.IMDG_CLSS_CD    = @[imdg_clss_cd_ctnt]" ).append("\n"); 
		query.append("AND       X.IMDG_UN_NO      = @[imdg_un_no_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}