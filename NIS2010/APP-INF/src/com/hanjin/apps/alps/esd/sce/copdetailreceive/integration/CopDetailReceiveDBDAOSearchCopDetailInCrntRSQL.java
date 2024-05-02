/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailInCrntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.07 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopDetailInCrntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetailInCrnt
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailInCrntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_CRNT_VSL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_CRNT_SKD_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_ORG_YD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("P_ACT_RCV_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_CRNT_SKD_VOY_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_COP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("IN_MVMT_STS_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailInCrntRSQL").append("\n"); 
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
		query.append("SELECT A.COP_NO             v_cop_no" ).append("\n"); 
		query.append(",A.COP_DTL_SEQ        v_cop_dtl_seq" ).append("\n"); 
		query.append(",A.NOD_CD             v_cop_nod_cd" ).append("\n"); 
		query.append(",A.ACT_STS_CD         v_cop_act_sts_cd" ).append("\n"); 
		query.append(",B.ACT_RCV_TP_CD      v_act_rcv_tp_cd" ).append("\n"); 
		query.append(",B.ACT_STS_MAPG_CD    v_cop_act_sts_mapg_cd" ).append("\n"); 
		query.append(",A.VSL_CD             v_vsl_cd" ).append("\n"); 
		query.append(",A.SKD_VOY_NO         v_skd_voy_no" ).append("\n"); 
		query.append(",A.SKD_DIR_CD         v_skd_dir_cd" ).append("\n"); 
		query.append(",A.STND_EDI_STS_CD    v_act_stnd_edi_sts_cd" ).append("\n"); 
		query.append(",A.ACT_STS_CD         v_act_sts_cd" ).append("\n"); 
		query.append(",A.ACT_CD             v_act_cd" ).append("\n"); 
		query.append(",( CASE WHEN @[IN_MVMT_STS_CD] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[IN_CRNT_VSL_CD], @[IN_CRNT_SKD_VOY_NO], @[IN_CRNT_SKD_DIR_CD]))" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '1'" ).append("\n"); 
		query.append("WHEN @[IN_MVMT_STS_CD] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[IN_CRNT_VSL_CD], @[IN_CRNT_SKD_VOY_NO], @[IN_CRNT_SKD_DIR_CD]))" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '2'" ).append("\n"); 
		query.append("WHEN @[IN_MVMT_STS_CD] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) NOT IN ( (@[IN_CRNT_VSL_CD], @[IN_CRNT_SKD_VOY_NO], @[IN_CRNT_SKD_DIR_CD]))" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '3'" ).append("\n"); 
		query.append("WHEN @[IN_MVMT_STS_CD] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) NOT IN ( (@[IN_CRNT_VSL_CD], @[IN_CRNT_SKD_VOY_NO], @[IN_CRNT_SKD_DIR_CD]))" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '4'" ).append("\n"); 
		query.append("WHEN ((@[IN_MVMT_STS_CD] = 'VL' AND @[IN_CRNT_VSL_CD] = '' AND @[IN_CRNT_SKD_VOY_NO] = '' AND @[IN_CRNT_SKD_DIR_CD] = '') OR @[IN_MVMT_STS_CD] != 'VL')" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '5'" ).append("\n"); 
		query.append("WHEN ((@[IN_MVMT_STS_CD] = 'VL' AND @[IN_CRNT_VSL_CD] = '' AND @[IN_CRNT_SKD_VOY_NO] = '' AND @[IN_CRNT_SKD_DIR_CD] = '') OR @[IN_MVMT_STS_CD] != 'VL')" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '6'" ).append("\n"); 
		query.append("ELSE '7' END )  v_chklvl" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL A" ).append("\n"); 
		query.append(",SCE_ACT_ACT_MAPG B" ).append("\n"); 
		query.append("WHERE  A.COP_NO          = @[IN_COP_NO]" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND    CASE WHEN @[IN_MVMT_STS_CD] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[IN_CRNT_VSL_CD], @[IN_CRNT_SKD_VOY_NO], @[IN_CRNT_SKD_DIR_CD])) THEN 'TRUE'" ).append("\n"); 
		query.append("WHEN @[IN_MVMT_STS_CD] != 'VL' THEN 'TRUE'" ).append("\n"); 
		query.append("ELSE 'FALSE' END = 'TRUE'" ).append("\n"); 
		query.append("AND    (" ).append("\n"); 
		query.append("(DECODE(  B.ACT_STS_MAPG_CD, 'VL', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'VD', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'AL', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'UR', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'AR', DECODE(SUBSTR(A.NOD_CD,1,2),'US',SUBSTR(A.NOD_CD, 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD)," ).append("\n"); 
		query.append("'RL', DECODE(SUBSTR(A.NOD_CD,1,2),'US',SUBSTR(A.NOD_CD, 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD)," ).append("\n"); 
		query.append("A.NOD_CD)" ).append("\n"); 
		query.append("= DECODE(@[IN_MVMT_STS_CD]," ).append("\n"); 
		query.append("'VL', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'VD', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'AL', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'UR', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'AR', DECODE(SUBSTR(@[IN_ORG_YD_CD],1,2),'US',SUBSTR(@[IN_ORG_YD_CD], 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), @[IN_ORG_YD_CD])," ).append("\n"); 
		query.append("'RL', DECODE(SUBSTR(@[IN_ORG_YD_CD],1,2),'US',SUBSTR(@[IN_ORG_YD_CD], 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), @[IN_ORG_YD_CD])," ).append("\n"); 
		query.append("@[IN_ORG_YD_CD])" ).append("\n"); 
		query.append(") OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.COP_DTL_SEQ > 6000" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DECODE(B.ACT_STS_MAPG_CD, 'IC', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'ID', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'EN', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'TN', SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD )" ).append("\n"); 
		query.append("= DECODE(:IN_MVMT_STS_CD, 'IC', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'ID', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'EN', SUBSTR(@[IN_ORG_YD_CD], 1, 5)," ).append("\n"); 
		query.append("'TN', SUBSTR(@[IN_ORG_YD_CD], 1, 5), @[IN_ORG_YD_CD])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    A.ACT_CD          = B.ACT_CD" ).append("\n"); 
		query.append("AND    B.ACT_RCV_TP_CD   = @[P_ACT_RCV_TP_CD]" ).append("\n"); 
		query.append("AND    B.ACT_STS_MAPG_CD = @[IN_MVMT_STS_CD]" ).append("\n"); 
		query.append("ORDER BY v_chklvl, A.COP_DTL_SEQ" ).append("\n"); 

	}
}