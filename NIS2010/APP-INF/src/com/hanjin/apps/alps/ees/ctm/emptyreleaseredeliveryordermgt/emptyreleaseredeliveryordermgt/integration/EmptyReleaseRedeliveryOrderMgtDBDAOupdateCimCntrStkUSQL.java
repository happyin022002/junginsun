/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.10.14 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SYS_AREA_GRP_ID가 EUR인 경우 Stock 처리
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL").append("\n"); 
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
		query.append("#if (${mvmt_sts_cd} == 'VL')" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET  STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND     STK_GATE_IO_CD  = 'O'" ).append("\n"); 
		query.append("AND     STK_LOC_CD      = SUBSTR(@[org_yd_cd],1,5)	-- 2008.05.19 LOC 조건 추가." ).append("\n"); 
		query.append("AND     STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append("#elseif (${mvmt_sts_cd} == 'XX')" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET  STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("AND     STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append("#elseif (${mvmt_sts_cd} == 'OP')" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET  STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND     CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND     STK_GATE_IO_CD  = 'O'" ).append("\n"); 
		query.append("AND     STK_LOC_CD      = SUBSTR(@[org_yd_cd],1,5)	-- 2008.05.19 LOC 조건 추가." ).append("\n"); 
		query.append("AND     STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append("#elseif (${mvmt_sts_cd} == 'MT')" ).append("\n"); 
		query.append("#if (${prev_sts_cd} == 'EN' || ${prev_sts_cd} == 'TN')" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET  STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   STK_LOC_CD      = SUBSTR(@[org_yd_cd], 0, 5)" ).append("\n"); 
		query.append("AND   STK_YD_CD       = @[org_yd_cd]" ).append("\n"); 
		query.append("AND   NVL(CNTR_NO, @[cntr_no])    = @[cntr_no]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND   TRSP_SO_TP_CD              = 'R'" ).append("\n"); 
		query.append("AND   STK_GATE_IO_CD             = 'I'" ).append("\n"); 
		query.append("AND   STL_FLG                    = 'N'" ).append("\n"); 
		query.append("AND   ROWNUM                     = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET  STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE  CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("AND  STK_GATE_IO_CD  = 'I'" ).append("\n"); 
		query.append("AND  STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND  ROWNUM  = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${mvmt_sts_cd} == 'EN' || ${mvmt_sts_cd} == 'TN')" ).append("\n"); 
		query.append("#if (${prev_sts_cd} == 'MT')" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET     STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   STK_YD_CD       = @[org_yd_cd]" ).append("\n"); 
		query.append("AND     CNTR_NO         = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND     TRSP_SO_TP_CD   = 'S'" ).append("\n"); 
		query.append("AND     STK_GATE_IO_CD  = 'O'" ).append("\n"); 
		query.append("AND     STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE  CIM_CNTR_STK" ).append("\n"); 
		query.append("SET     STL_FLG         = 'Y'," ).append("\n"); 
		query.append("MVMT_CNTR_NO    = @[cntr_no]," ).append("\n"); 
		query.append("CNMV_YR         = @[cnmv_yr]," ).append("\n"); 
		query.append("CNMV_ID_NO      = (SELECT MAX(CNMV_ID_NO) FROM CTM_MOVEMENT WHERE CNMV_YR = @[cnmv_yr] AND CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("DRP_OFF_CHG_DEST_RMK = NULL" ).append("\n"); 
		query.append("WHERE   STK_LOC_CD      = SUBSTR(@[org_yd_cd], 0, 5)" ).append("\n"); 
		query.append("AND   STK_YD_CD       = @[org_yd_cd]" ).append("\n"); 
		query.append("AND     NVL(CNTR_NO, @[cntr_no]) = @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_TPSZ_CD    = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND     TRSP_SO_TP_CD   = 'R'" ).append("\n"); 
		query.append("AND     STK_GATE_IO_CD  = 'O'" ).append("\n"); 
		query.append("AND     STL_FLG         = 'N'" ).append("\n"); 
		query.append("AND     ROWNUM          = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}