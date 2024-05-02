/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDangerRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.20 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchContainerDangerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 대만세관 신고용 Manifest Container Danger 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchContainerDangerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n");
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDangerRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("NVL(DG.IMDG_UN_NO,' ') unnbr," ).append("\n");
		query.append("NVL(UN.IMDG_CLSS_CD,' ') imdg_class," ).append("\n");
		query.append("NVL(DG.PRP_SHP_NM,' ') desc_remark," ).append("\n");
		query.append("NVL(DG.EMER_CNTC_PHN_NO_CTNT,' ') phone," ).append("\n");
		query.append("' ' d_page," ).append("\n");
		query.append("NVL(UN.FLSH_PNT_TEMP_CTNT,0) flsh_temp," ).append("\n");
		query.append("' '  flsh_unit," ).append("\n");
		query.append("REPLACE(NVL(DG.DIFF_RMK,' '),CHR(10),' ') dg_remark" ).append("\n");
		query.append("FROM  BKG_DG_CGO DG, SCG_IMDG_UN_NO UN" ).append("\n");
		query.append("WHERE DG.IMDG_UN_NO = UN.IMDG_UN_NO(+)" ).append("\n");
		query.append("AND DG.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ(+)" ).append("\n");
		query.append("AND DG.CNTR_NO(+)    = @[cntr_no]" ).append("\n");
		query.append("AND DG.BKG_NO        = @[bkg_no]" ).append("\n");

	}
}