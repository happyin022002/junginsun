/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeMgtDBDAOremoveIntgCdToMnrDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeMgtDBDAOremoveIntgCdToMnrDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public GeneralCodeMgtDBDAOremoveIntgCdToMnrDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeMgtDBDAOremoveIntgCdToMnrDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("        MNR_CD_SEQ = (SELECT MNR_CD_SEQ" ).append("\n"); 
		query.append("                        FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                       WHERE PAIR_CD_ID = @[pair_cd_id]" ).append("\n"); 
		query.append("                         AND PAIR_REF_CD = @[pair_ref_cd])" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#if(${mnr_cd_grp_no} == '2')" ).append("\n"); 
		query.append("   OR   (" ).append("\n"); 
		query.append("        A.MNR_CD_GRP_NO = '3'" ).append("\n"); 
		query.append("        AND @[pair_cd_id] = A.PAIR_REF_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}