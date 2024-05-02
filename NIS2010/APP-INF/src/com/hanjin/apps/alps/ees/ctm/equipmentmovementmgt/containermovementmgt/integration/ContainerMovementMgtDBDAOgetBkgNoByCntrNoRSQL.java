/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgNoByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.10.21 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgNoByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 번호를 입력 받고 부킹 번호를 리턴한다. 
	  * BKG_CONTAINER . BKG_BOOKING테이블을 조회
	  * 
	  * --------------------------------------------------------
	  * History
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
	public ContainerMovementMgtDBDAOgetBkgNoByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgNoByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(B XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("       A.BKG_NO, NVL (A.BB_CGO_FLG, '') AS BB_CGO_FLG" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A," ).append("\n"); 
		query.append("       BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO =" ).append("\n"); 
		query.append("          (SELECT /*+ ORDERED INDEX_DESC(BC XAK1BKG_CONTAINER) INDEX(BO XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("                  MAX (CNMV_CYC_NO)" ).append("\n"); 
		query.append("             FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("                  BKG_BOOKING BO" ).append("\n"); 
		query.append("            WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("              AND NVL (BO.BKG_STS_CD, ' ') NOT IN ('X', 'S'))" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}