/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchVesselForMRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.03.04 이수진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Su Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchVesselForMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 호주세관으로 전송할 Vessel 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchVesselForMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchVesselForMRSQL").append("\n");
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
		query.append("SELECT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD vvd_number" ).append("\n");
		query.append("FROM BKG_BOOKING B," ).append("\n");
		query.append("MDM_REP_CMDT COM," ).append("\n");
		query.append("MDM_COMMODITY CMD," ).append("\n");
		query.append("BKG_VVD VVD" ).append("\n");
		query.append("WHERE  VVD.VSL_CD         = @[vsl_cd]" ).append("\n");
		query.append("AND VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n");
		query.append("AND VVD.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n");
		query.append("#if (${pol_cd}!= '')" ).append("\n");
		query.append("AND VVD.POL_CD        = @[pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod_cd}!= '')" ).append("\n");
		query.append("AND VVD.POD_CD        = @[pod_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND B.BKG_STS_CD           != 'X'" ).append("\n");
		query.append("AND B.BKG_STS_CD           != 'S'" ).append("\n");
		query.append("AND B.REP_CMDT_CD      = COM.REP_CMDT_CD(+)" ).append("\n");
		query.append("AND B.CMDT_CD 	= CMD.CMDT_CD(+)" ).append("\n");
		query.append("AND B.BKG_NO = VVD.BKG_NO" ).append("\n");
		query.append("AND ROWNUM =1" ).append("\n");

	}
}