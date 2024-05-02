/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ModelManageDBDAOModifyExistSmpYieldGroupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.10.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOModifyExistSmpYieldGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * account yield group 이 SMP Main 입력해 둔 정보와 달라지는 경우, 기존재하는 smp data 내 yield group을 변경
	  * 
	  * * 2013.07.25 [CHM-201325929-01] SMP save 후 Yield Group변경시, SPC_MDL_CUST_REV_LANE UPDATE
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.12.29 선반영 이혜민 SMP 저장 로직 보완
	  * 2017.10.19 송민석 SMP 저장시 CUST_CTRL_CD update하는 부분에 오류수정
	  * </pre>
	  */
	public ModelManageDBDAOModifyExistSmpYieldGroupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOModifyExistSmpYieldGroupUSQL").append("\n"); 
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
		query.append("UPDATE SPC_MDL_CUST_REV_LANE R" ).append("\n"); 
		query.append("   SET CUST_CTRL_CD = (" ).append("\n"); 
		query.append("						SELECT first_value(CUST_CTRL_CD) over (partition by TRD_CD, COST_YRWK, VER_SEQ, CUST_CNT_CD, CUST_SEQ order by  DTL_SEQ desc )" ).append("\n"); 
		query.append("                         FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("                        WHERE R.COST_YRWK        = C.COST_YRWK" ).append("\n"); 
		query.append("                          AND R.VER_SEQ          = C.VER_SEQ" ).append("\n"); 
		query.append("                          AND R.TRD_CD           = C.TRD_CD" ).append("\n"); 
		query.append("                          AND R.CUST_CNT_CD      = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                          AND R.CUST_SEQ         = C.CUST_SEQ" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("   AND TRD_CD    = @[trade]" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("                WHERE C.TRD_CD           = @[trade]" ).append("\n"); 
		query.append("                  AND C.COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("                  AND C.VER_SEQ          = @[ver_seq]" ).append("\n"); 
		query.append("                  AND R.COST_YRWK        = C.COST_YRWK" ).append("\n"); 
		query.append("                  AND R.VER_SEQ          = C.VER_SEQ" ).append("\n"); 
		query.append("                  AND R.TRD_CD           = C.TRD_CD" ).append("\n"); 
		query.append("                  AND R.CUST_CNT_CD      = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND R.CUST_SEQ         = C.CUST_SEQ" ).append("\n"); 
		query.append("                  AND NVL(R.RFA_NO, ' ') = NVL(C.RFA_NO, ' ')" ).append("\n"); 
		query.append("                  AND NVL(R.SC_NO , ' ') = NVL(C.SC_NO , NVL(R.SC_NO, ' '))" ).append("\n"); 
		query.append("                  AND R.CUST_CTRL_CD    <> C.CUST_CTRL_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}