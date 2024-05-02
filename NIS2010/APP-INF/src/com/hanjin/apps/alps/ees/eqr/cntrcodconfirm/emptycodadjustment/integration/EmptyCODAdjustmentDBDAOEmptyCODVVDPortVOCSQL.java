/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODVVDPortVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyCODVVDPortVO 입력
	  * 2012.10.30 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODVVDPortVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creusrid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yardcode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updusrid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clptindseq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("o4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODVVDPortVOCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_MTY_COD_PORT(" ).append("\n"); 
		query.append("     VSL_CD" ).append("\n"); 
		query.append("   , SKD_VOY_NO" ).append("\n"); 
		query.append("   , SKD_DIR_CD" ).append("\n"); 
		query.append("   , COD_CFM_DIV_CD" ).append("\n"); 
		query.append("   , PORT_CD" ).append("\n"); 
		query.append("   , CLPT_IND_SEQ" ).append("\n"); 
		query.append("   , LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("   , YD_CD" ).append("\n"); 
		query.append("   , ETB_DT" ).append("\n"); 
		query.append("   , D2_QTY" ).append("\n"); 
		query.append("   , D4_QTY" ).append("\n"); 
		query.append("   , D5_QTY" ).append("\n"); 
		query.append("   , D7_QTY" ).append("\n"); 
		query.append("   , R2_QTY" ).append("\n"); 
		query.append("   , R4_QTY" ).append("\n"); 
		query.append("   , R5_QTY" ).append("\n"); 
		query.append("   , O2_QTY" ).append("\n"); 
		query.append("   , O4_QTY" ).append("\n"); 
		query.append("   , F2_QTY" ).append("\n"); 
		query.append("   , F4_QTY" ).append("\n"); 
		query.append("   , D8_QTY" ).append("\n"); 
		query.append("   , D9_QTY" ).append("\n"); 
		query.append("   , DW_QTY" ).append("\n"); 
		query.append("   , DX_QTY" ).append("\n"); 
		query.append("   , A2_QTY" ).append("\n"); 
		query.append("   , A4_QTY" ).append("\n"); 
		query.append("   , A5_QTY" ).append("\n"); 
		query.append("   , P2_QTY" ).append("\n"); 
		query.append("   , P4_QTY" ).append("\n"); 
		query.append("   , S2_QTY" ).append("\n"); 
		query.append("   , S4_QTY" ).append("\n"); 
		query.append("   , T2_QTY" ).append("\n"); 
		query.append("   , T4_QTY" ).append("\n"); 
		query.append("   , F5_QTY" ).append("\n"); 
		query.append("   , O5_QTY" ).append("\n"); 
		query.append("   , CRE_OFC_CD" ).append("\n"); 
		query.append("   , UPD_OFC_CD" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("     SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   , SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   , SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("   , 'S'" ).append("\n"); 
		query.append("   , @[pod]" ).append("\n"); 
		query.append("   , @[clptindseq]" ).append("\n"); 
		query.append("   , 'D'" ).append("\n"); 
		query.append("   , @[yardcode]" ).append("\n"); 
		query.append("   , TO_DATE(@[etb],'YYYY/MM/DD')" ).append("\n"); 
		query.append("   , @[d2]" ).append("\n"); 
		query.append("   , @[d4]" ).append("\n"); 
		query.append("   , @[d5]" ).append("\n"); 
		query.append("   , @[d7]" ).append("\n"); 
		query.append("   , @[r2]" ).append("\n"); 
		query.append("   , 0 " ).append("\n"); 
		query.append("   , @[r5]" ).append("\n"); 
		query.append("   , @[o2]" ).append("\n"); 
		query.append("   , @[o4]" ).append("\n"); 
		query.append("   , @[f2]" ).append("\n"); 
		query.append("   , @[f4]" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , @[a2]" ).append("\n"); 
		query.append("   , @[a4]" ).append("\n"); 
		query.append("   , @[a5]" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , 0" ).append("\n"); 
		query.append("   , @[s2]" ).append("\n"); 
		query.append("   , @[s4]" ).append("\n"); 
		query.append("   , @[t2]" ).append("\n"); 
		query.append("   , @[t4]" ).append("\n"); 
		query.append("   , @[f5]" ).append("\n"); 
		query.append("   , @[o5]" ).append("\n"); 
		query.append("   , @[ofccd]" ).append("\n"); 
		query.append("   , @[ofccd]" ).append("\n"); 
		query.append("   , @[creusrid]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[updusrid]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}