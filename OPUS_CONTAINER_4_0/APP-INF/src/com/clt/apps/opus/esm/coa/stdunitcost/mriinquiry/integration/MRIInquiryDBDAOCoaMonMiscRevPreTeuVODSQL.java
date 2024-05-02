/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MRIInquiryDBDAOCoaMonMiscRevPreTeuVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.03.03 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHOISUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOCoaMonMiscRevPreTeuVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MRI Inquiry (PA/RA) 정보를 삭제한다.
	  * </pre>
	  */
	public MRIInquiryDBDAOCoaMonMiscRevPreTeuVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration ").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOCoaMonMiscRevPreTeuVODSQL").append("\n"); 
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
		query.append("  FROM COA_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append(" WHERE REV_YRMON      = @[rev_yrmon]" ).append("\n"); 
		query.append("   AND TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("   AND DIR_CD         = @[dir_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD       = @[rlane_cd]" ).append("\n"); 

	}
}