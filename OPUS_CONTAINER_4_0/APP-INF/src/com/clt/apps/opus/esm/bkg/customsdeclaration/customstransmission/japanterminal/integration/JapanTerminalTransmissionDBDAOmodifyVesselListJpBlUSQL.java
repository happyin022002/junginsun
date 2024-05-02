/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.06.12 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * voyage  number 수정 및 입력 시 By BKG 화면에서 쓰이는 BKG_TML_EDI_JP_BL 테이블에도 업데이트 시켜줌
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOmodifyVesselListJpBlUSQL").append("\n");
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
		query.append("UPDATE BKG_TML_EDI_JP_BL " ).append("\n");
		query.append("SET " ).append("\n");
		query.append("BKG_SKD_DELT_FLG  = 'N'" ).append("\n");
		query.append("WHERE	1=1" ).append("\n");
		query.append("--AND BKG_NO = " ).append("\n");
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append("AND POL_CD    =@[pol_cd]" ).append("\n");
		query.append("AND POL_YD_CD = @[pol_yd_cd]" ).append("\n");
		query.append("AND POR_CD    =@[por_cd]" ).append("\n");
		query.append("AND POR_YD_CD = NVL(@[por_yd_cd],'')" ).append("\n");

	}
}