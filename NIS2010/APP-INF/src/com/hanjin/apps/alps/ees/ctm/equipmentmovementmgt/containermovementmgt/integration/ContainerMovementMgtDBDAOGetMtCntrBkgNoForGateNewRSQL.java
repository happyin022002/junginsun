/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetMtCntrBkgNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.05
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.11.05 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI, Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetMtCntrBkgNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.03.08 나상보 
	  *                   - Revenue Empty Cargo 인 경우는 VL 일때 9999만 찾는게 아니라 9999 또는 max 값을 찾게 한다. 
	  *                     어차피 9999 가 있으면 그게 max 값이므로 R 인 경우는 조건을 뺀다.
	  * 
	  * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
	  *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
	  *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
	  *                     자동생성 로직이 탈수있도록 소스수정
	  *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
	  *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
	  *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
	  *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetMtCntrBkgNoForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetMtCntrBkgNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("	   BKG_VVD BV" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO =" ).append("\n"); 
		query.append("          (SELECT MAX (CNMV_CYC_NO)" ).append("\n"); 
		query.append("             FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("                  BKG_BOOKING BO" ).append("\n"); 
		query.append("            WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("              AND NVL (BO.BKG_STS_CD, '') NOT IN ('X', 'S', 'A')" ).append("\n"); 
		query.append("              AND BC.CNMV_CYC_NO <> DECODE (@[gate_io_cd], 'UV', 9999, 0)" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != 'R')" ).append("\n"); 
		query.append("              AND BC.CNMV_CYC_NO = DECODE (@[gate_io_cd], 'AE', 9999, BC.CNMV_CYC_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("              AND BC.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND BV.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, '') NOT IN ('X', 'S', 'A')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("   AND DECODE (@[gate_io_cd], 'AE', BV.POL_CD, BV.POD_CD) = SUBSTR (@[event_yard], 1, 5)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}