/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCrnNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.28
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.28 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCrnNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * transmit. BayPlanCntrDetailVO
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCrnNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCrnNoRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD||B.TURN_SKD_VOY_NO||B.TURN_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("	  ,A.CVY_REF_NO " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("BKG_CSTMS_CND_VSL A," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A.PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("AND B.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("	  ,CVY_REF_NO " ).append("\n"); 
		query.append("FROM BKG_CSTMS_CND_VSL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("AND PORT_CD = @[vps_port_cd]" ).append("\n"); 

	}
}