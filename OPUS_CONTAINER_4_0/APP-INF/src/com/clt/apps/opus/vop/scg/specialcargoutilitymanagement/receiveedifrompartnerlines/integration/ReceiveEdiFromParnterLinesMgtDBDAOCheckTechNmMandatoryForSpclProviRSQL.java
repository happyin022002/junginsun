/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckTechNmMandatoryForSpclProviRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
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

public class ReceiveEdiFromParnterLinesMgtDBDAOCheckTechNmMandatoryForSpclProviRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckTechNmMandatoryForSpclProvi
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCheckTechNmMandatoryForSpclProviRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCheckTechNmMandatoryForSpclProviRSQL").append("\n"); 
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
		query.append("SELECT    Y.IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append("FROM      SCG_IMDG_UN_NO                X" ).append("\n"); 
		query.append("       ,  SCG_IMDG_UN_NO_SPCL_PROVI     Y" ).append("\n"); 
		query.append("WHERE     X.IMDG_UN_NO                  = Y.IMDG_UN_NO" ).append("\n"); 
		query.append("AND       X.IMDG_UN_NO_SEQ              = Y.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("AND       X.IMDG_AMDT_NO                = @[imdg_amdt_no]" ).append("\n"); 
		query.append("AND       X.IMDG_UN_NO                  = @[imdg_un_no_ctnt]" ).append("\n"); 
		query.append("AND       Y.IMDG_SPCL_PROVI_NO          IN ('274','318')" ).append("\n"); 

	}
}