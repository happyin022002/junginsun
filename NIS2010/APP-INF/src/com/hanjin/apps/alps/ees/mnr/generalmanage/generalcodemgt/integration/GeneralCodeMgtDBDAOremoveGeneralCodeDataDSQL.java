/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDAOremoveGeneralCodeDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.26 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeMgtDBDAOremoveGeneralCodeDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제
	  * </pre>
	  */
	public GeneralCodeMgtDBDAOremoveGeneralCodeDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("AND  (" ).append("\n"); 
		query.append("MNR_CD_SEQ = @[mnr_cd_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_cd_grp_no} == '1')" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.MNR_CD_GRP_NO = '2'" ).append("\n"); 
		query.append("AND @[mnr_cd_id] = A.PRNT_CD_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.MNR_CD_GRP_NO = '3'" ).append("\n"); 
		query.append("AND A.PRNT_CD_ID IN ( SELECT MNR_CD_ID" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE MNR_CD_GRP_NO = '2'" ).append("\n"); 
		query.append("AND PRNT_CD_ID = @[mnr_cd_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${mnr_cd_grp_no} == '2')" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.MNR_CD_GRP_NO = '3'" ).append("\n"); 
		query.append("AND @[mnr_cd_id] = A.PRNT_CD_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
	}
}