/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOModifySpExistFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.14 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBiddingManageDBDAOModifySpExistFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_SPOT_BID_CNDDT_VNDR 테이블에 SPP에 Vendor가 존재하는지 유무 업데이트
	  * </pre>
	  */
	public SpotBiddingManageDBDAOModifySpExistFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOModifySpExistFlgUSQL").append("\n"); 
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
		query.append("UPDATE TRS_SPOT_BID_CNDDT_VNDR" ).append("\n"); 
		query.append("   SET SP_PTAL_EXIST_FLG = (SELECT MAX(SP_EXIST_FLG)" ).append("\n"); 
		query.append("                              FROM (SELECT  ROW_NUMBER() OVER(PARTITION BY A.SP_VNDR_SEQ, A.SP_USR_ID ORDER BY A.CRE_DT DESC) RNK" ).append("\n"); 
		query.append("                                           ,A.SP_EXIST_FLG" ).append("\n"); 
		query.append("                                      FROM TRS_SVC_PROV_PTAL_USR_IF A" ).append("\n"); 
		query.append("                                     WHERE A.SP_VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("							  WHERE RNK =1" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(" WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}