/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchSrnVslIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchSrnVslIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017-08-22] Ship Call Number, Vessel ID 조회
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchSrnVslIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchSrnVslIdRSQL").append("\n"); 
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
		query.append("SELECT CVY_REF_NO AS VSL_CALL_NO, UQ_VSL_ID_NO AS VSL_ID" ).append("\n"); 
		query.append("	 FROM BKG_VSL_DCHG_YD D " ).append("\n"); 
		query.append("	WHERE D.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	  AND D.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	  AND D.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	#if (${e_i_ind} == 'E')" ).append("\n"); 
		query.append("	  AND D.PORT_CD = @[input_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  AND D.PORT_CD = @[input_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("	#end             " ).append("\n"); 
		query.append("	  AND ROWNUM = 1  " ).append("\n"); 

	}
}